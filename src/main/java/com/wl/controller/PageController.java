package com.wl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import com.wl.util.Log;


/**
 * 基础跳转
 * @author wuli
 * @date 2019年12月26日下午3:40:43
 */
@Controller
public class PageController {
	
	@RequestMapping("page/{url}/**")
	public String page(HttpServletRequest request,Model model, @PathVariable("url") String url) {
		Log.deubg("大飒飒大苏打");
		String subUrlString = extractPathFromPattern(request);
		if (StringUtils.isEmpty(subUrlString)) {
			model.addAttribute("name", url);
		}else {
			model.addAttribute("name", url+"/"+subUrlString);
		}
		return "index";
	}

	private String extractPathFromPattern(final HttpServletRequest request) {
		String path = (String) request
				.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String bestMatchPattern = (String) request
				.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
	}

}
