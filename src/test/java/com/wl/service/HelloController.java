package com.wl.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wl.model.po.Hello;
import com.wl.model.po.User;

@Controller
public class HelloController {
	
	@Autowired
    private HttpServletRequest request; //自动注入request
	
	@RequestMapping("table")
	public String table() {
		return "content/list";
	}
	
	@RequestMapping("v1/{name}")
	public String hello(@PathVariable("name")String name) {
		request.setAttribute("name", name);
		return "index";
	}
	
	@RequestMapping(value = "json",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public String hello2() {
		Hello hello =new Hello();
		hello.setNames(new String[] {"123","fds","3234rf"});
		hello.setName("test");
//		helloService.save(hello);
		ObjectMapper mapper = new ObjectMapper();
		String json =""; 
		try {
			json = mapper.writeValueAsString(hello);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping("advice")
	public String advice(@ModelAttribute("msg")String msg) throws IllegalAccessException {
		throw new IllegalAccessException("内部错误"+msg);
	}
	
	@RequestMapping(value = "upload",method = RequestMethod.POST)
	@ResponseBody
	public String upload(MultipartFile file) throws IOException {
		File uploadFile = new File("d:/upload/"+file.getOriginalFilename());
		FileUtils.writeByteArrayToFile(uploadFile, file.getBytes());
		return "ok";
	}
	
	
	@RequestMapping(value = "uploada",method = RequestMethod.POST)
	public String uploada(User user) throws IOException {
		return "ok";
	}
	
	@RequestMapping(value = "test",method = RequestMethod.GET)
	public String test(Model model) {
		model.addAttribute("info", "ss");
		return "upload";
	}
	
	
}
