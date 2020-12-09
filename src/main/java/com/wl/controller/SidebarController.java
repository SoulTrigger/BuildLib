package com.wl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wl.model.po.Community;
import com.wl.service.SidebarService;

@Controller
public class SidebarController {
	
	@Autowired
	SidebarService sidebarService;
	
	@RequestMapping(value = "sidebar",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Community> get() {
		return sidebarService.list();
	}
}
