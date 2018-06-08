package com.yoyo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yoyo.common.Assist;
import com.yoyo.common.Result;
import com.yoyo.common.Assist.WhereRequire;
import com.yoyo.entity.SysResource;
import com.yoyo.entity.SysUser;
import com.yoyo.service.SysDeptService;
import com.yoyo.service.SysResourceService;
import com.yoyo.util.UUIDutil;

@Controller
@RequestMapping("/sysDept")
public class SysDeptController {
	
	@Autowired
	private SysDeptService sysDeptService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getSysResourceListPage(){
		return "sysPage/sysDept/list";
	}
	
	
	
	@RequestMapping(value = {"/save","/update"}, method = RequestMethod.POST)
	@ResponseBody
	public Result<SysResource> saveOrupdate(@RequestBody SysResource sysResource){
		return null;
		
	}
	
	
}
