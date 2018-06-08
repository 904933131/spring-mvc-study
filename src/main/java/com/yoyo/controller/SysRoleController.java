package com.yoyo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yoyo.common.Assist;
import com.yoyo.common.Assist.WhereRequire;
import com.yoyo.common.Result;
import com.yoyo.entity.SysRole;
import com.yoyo.entity.SysUser;
import com.yoyo.entity.SysUserRole;
import com.yoyo.service.SysRoleService;
import com.yoyo.service.SysUserRoleService;
import com.yoyo.service.SysUserService;
import com.yoyo.util.UUIDutil;

@Controller
@RequestMapping("/sysRole")
public class SysRoleController {
	
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String  toListPage(){
		return "sysPage/sysRole/list";
	}
	
	@RequestMapping(value="/sysGrantList",method=RequestMethod.GET)
	public String  toGrantListPage(){
		return "sysPage/sysRole/grantList";
	}
	
	@RequestMapping(value="/ajax/list",method=RequestMethod.POST)
	@ResponseBody
	public Result<SysRole> getRoleList(@RequestParam(required = false) String name, @RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex, @RequestParam(required = false) Integer pageSize){
		Result<SysRole> result = new Result<SysRole>();
		Assist assist = new Assist();
		if(null != pageindex && null != pageSize){
			assist.setStartRow((pageindex-1)*pageSize);
			assist.setRowSize(pageSize);
		}
		assist.setOrder("seq,id", true);
		if(null != name && !"".equals(name)){
			assist.setRequires(Assist.andLike("name", "%"+name+"%"));
		}
		long count = sysRoleService.getSysRoleRowCount(assist);
		List<SysRole> list =  sysRoleService.selectSysRole(assist);
		result.setTotalCount(count);
		result.setDataList(list);
		return result;
	}
	
	@RequestMapping(value="/ajax/grantList",method=RequestMethod.POST)
	@ResponseBody
	public Result<SysUserRole> getUserGrant(@RequestParam(required = false) String name, @RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex, @RequestParam(required = false) Integer pageSize){
		Result<SysUserRole> result = new Result<SysUserRole>();
		Assist assist = new Assist();
		assist.setStartRow((pageindex-1)*pageSize);
		assist.setRowSize(pageSize);
		if(null != name && !"".equals(name)){
			assist.setRequires(Assist.andLike("name", "%"+name+"%"));
		}
		long count = sysUserRoleService.getSysUserRoleRowCount(assist);
		List<SysUserRole> list = sysUserRoleService.selectSysUserRole(assist);
		result.setTotalCount(count);
		result.setDataList(list);
		return result;
	}
	
	@RequestMapping(value="/ajax/selectSysUserRoleByObj/{userId}",method=RequestMethod.POST)
	@ResponseBody
	public SysUserRole selectSysUserRoleByObj(@PathVariable("userId") String userId){
		Result<SysUserRole> result = new Result<SysUserRole>();
		SysUserRole ur = new SysUserRole();
		ur.setUserId(userId);
		SysUserRole sysUserRole = sysUserRoleService.selectSysUserRoleByObj(ur);
		return sysUserRole;
	}
	
	@RequestMapping(value={"/ajax/save","/ajax/update"},method=RequestMethod.POST)
	@ResponseBody
	public Result saveOrUpdate(@RequestBody SysRole role) {
		Result<SysRole> result = new Result<SysRole>();
		Map<String, Object> paramMap = new HashMap();
		paramMap.put("resourceIds", role.getResourceIds());
		if(role.getId() == null) {
			sysRoleService.insertNonEmptySysRole(role);
		}else {
			sysRoleService.updateSysRoleById(role);
			sysRoleService.deleteResources(role.getId());
		}
		paramMap.put("roleId", role.getId());
		sysRoleService.insertResources(paramMap);
		return result;
	}

	@RequestMapping(value="/ajax/delete/{roleId}",method=RequestMethod.POST)
	@ResponseBody
	public Result deleteByRoleId(@PathVariable("roleId") Long roleId) {
		Result<SysRole> result = new Result<SysRole>();
		sysRoleService.deleteSysRoleById(roleId);
		sysRoleService.deleteResources(roleId);
		return result;
	}
	
	
	@RequestMapping(value="/ajax/selectResourceByRoleId/{roleId}",method=RequestMethod.POST)
	@ResponseBody
	public SysRole selectResourceByRoleId(@PathVariable("roleId") Long roleId) {
		SysRole sysRole = sysRoleService.selectSysRoleById(roleId);
		List<Map<String,String>> list = sysRoleService.selectResourceByRoleId(roleId);
		String[] resourceIds = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			resourceIds[i] = list.get(i).get("resourceIds");
		}
		sysRole.setResourceIds(resourceIds);
		return sysRole;
	}
	
	
	@RequestMapping(value={"/ajax/grantSave","/ajax/grantUpdate"},method=RequestMethod.POST)
	@ResponseBody
	public Result grantSave(@RequestBody SysUserRole sysUserRole){
		Result<SysUserRole> result = new Result<SysUserRole>();
		if(null == sysUserRole.getId()){
			sysUserRole.setId(UUIDutil.getUUID());
			sysUserRoleService.insertNonEmptySysUserRole(sysUserRole);
		}else{
			sysUserRoleService.updateNonEmptySysUserRoleById(sysUserRole);
		}
		return result;
	}
}
