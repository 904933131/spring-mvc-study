/**
 * 
 */
package com.yoyo.shiro;

import java.security.Permissions;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.yoyo.common.Assist;
import com.yoyo.common.Assist.WhereRequire;
import com.yoyo.entity.SysResource;
import com.yoyo.entity.SysUser;
import com.yoyo.service.SysResourceService;
import com.yoyo.service.SysRoleService;
import com.yoyo.service.SysUserService;

/**
 * @author longrui
 * 2016年12月5日
 *	
 */
public class UserRealm extends AuthorizingRealm {
	
	@Autowired private SysUserService userService;
	@Autowired private SysRoleService sysRoleService;
	@Autowired private SysResourceService sysResourceService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		SysUser sysUser = (SysUser)principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermission("/index");
		Assist assist = new Assist();
		assist.setDistinct(true);
		WhereRequire<Long> require = Assist.andEq("rr.role_id", sysUser.getRoleId());
		assist.setRequires(require);
		List<SysResource> list =  sysResourceService.selectSysResource(assist);
		List<String> urlList = new LinkedList<>();
		for (SysResource sysResource : list) {
			if(!"".equals(sysResource.getUrl()) && sysResource.getUrl() != null){
				urlList.add(sysResource.getUrl());
			}
		}
		authorizationInfo.addStringPermissions(urlList);
		return authorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();
		SysUser sysUser = new SysUser();
		sysUser.setLoginName(username);
		SysUser user = userService.selectSysUserByObj(sysUser);
		if(user == null) throw new UnknownAccountException();
		//if(user.getLocked()) throw new LockedAccountException();
		//user.setMenus(resourceService.getMenus(user));
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user, user.getPassword(), getName());
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		Long roleId = sysRoleService.selectSysRoleByUserId(user.getId());
		user.setRoleId(roleId);
		session.setAttribute("users", user);
		return authenticationInfo;
	}
	
	@PostConstruct
	public void initCredentialsMatcher() {
		setCredentialsMatcher(new CustomCredentialsMatcher());
	}

}
