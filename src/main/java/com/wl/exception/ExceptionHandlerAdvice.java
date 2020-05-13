package com.wl.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.wl.util.Log;

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
	 * Exception类异常记录
	 * @return
	 * @Author:wuli
	 * @Description:
	 */	
	@ExceptionHandler(value = Exception.class)//value值为过滤拦截的条件
	public ModelAndView exception(Exception exception,WebRequest request) {
		Log.error("全局异常拦截",exception);
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMessage",exception.getMessage());
		return modelAndView;
	}
	
	@ModelAttribute
	public void addAttributes(Model model) {
//		model.addAttribute("msg","全局信息");
	}
	
	//绑定前台参数到model中
	@InitBinder
	public 	void initBinder(WebDataBinder binder) {
	}
}
