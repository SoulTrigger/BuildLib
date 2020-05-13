package com.wl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wl.base.BaseService;
import com.wl.model.po.Community;

@Controller
public class SidebarController {
	
	@Autowired
	BaseService<Community, String> communityService;
	
	@RequestMapping(value = "sidebar",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Community> get() {
		String hqlString = "from Community c where c.parent is null";
		return communityService.getListByHQL(hqlString);
	}
}
