/**
 * 
 */
package com.yoyo.shiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoyo.common.Result;

/**
 * @author longrui 2016年12月7日
 * 
 */
public class UrlPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {
	
	private static Logger logger = LoggerFactory.getLogger(UrlPermissionsAuthorizationFilter.class);
	
	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		Subject subject = getSubject(request, response);
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		int i = uri.indexOf(contextPath);
		if (i > -1) {
			uri = uri.substring(i + contextPath.length());
		}
		if (StringUtils.isBlank(uri)) {
			uri = "/";
		}

		boolean permitted = false;
		if ("/".equals(uri)) {
			permitted = true;
		} else {
			permitted = subject.isPermitted(uri);
		}
		return permitted;
	}
	
	@Override
	public boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
  
        Subject subject = getSubject(request, response);
        
        if(subject.getPrincipal() == null) {
        	if(this.isAjax(request)) {
        		this.sendJson(response, new com.yoyo.common.Result(401,"您尚未登录或登录时间过长,请重新登录!"));
        	}else {
        		saveRequestAndRedirectToLogin(request, response);  
        	}
        }else {
        	if(this.isAjax(request)) {
        		this.sendJson(response, new Result(403,"您没有足够的权限执行该操作!"));
        	}else {
        		String unauthorizedUrl = getUnauthorizedUrl();
                if (StringUtils.isNotEmpty(unauthorizedUrl)) {
                    WebUtils.issueRedirect(request, response, unauthorizedUrl);
                }else {
                    WebUtils.toHttp(response).sendError(403);
                }
        	}
        }
        return false;
	}
	
	private boolean isAjax(HttpServletRequest request) {
		return request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest");
	}
	
	private void sendJson(HttpServletResponse response, Result result) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try{
			out = response.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			out.append(mapper.writeValueAsString(result));
			out.close();
		}catch(IOException e) {
			logger.error(e.getMessage());
		}finally {
			if(out != null) out = null;
 		}
	}
}
