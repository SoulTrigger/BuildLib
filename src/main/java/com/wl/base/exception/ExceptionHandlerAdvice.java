package com.wl.base.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wl.base.util.Log;
import com.wl.model.dto.Page;
import com.wl.model.vo.JsonResults;

/**
 * 全局异常处理<br/>
 * 全局数据绑定<br/>
 * 全局数据预处理
 * @author wuli
 * @date 2019年11月21日下午4:02:55
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	/**
	 * 拦截所有异常
	 * @param exception
	 * @param request
	 * @return
	 * @Author:wuli
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)//value值为过滤拦截的条件
	public ModelAndView exception(Exception exception,WebRequest request) {
		Log.error("全局异常拦截",exception);
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("success", false);
		modelAndView.addObject("msg",exception.getMessage());
		if (request.getHeader("x-requested-with") != null
			    && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
			modelAndView.setView(new MappingJackson2JsonView());
		}
		return modelAndView;
	}
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("msg","全局信息");
	}
	
	//绑定前台参数到model中
	@InitBinder
	public 	void initBinder(WebDataBinder binder) {
		System.out.println();
	}
}
