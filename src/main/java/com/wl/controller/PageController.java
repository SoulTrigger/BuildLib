package com.wl.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import com.wl.base.util.Log;

/**
 * 基础跳转
 * 
 * @author wuli
 * @date 2019年12月26日下午3:40:43
 */
@Controller
public class PageController {

	@RequestMapping("page/{url}/**")
	public String toPage(HttpServletRequest request, Model model,
			@PathVariable("url") String url) {
		String subUrlString = extractPathFromPattern(request);
		String params = request.getQueryString();
		String access = "";
		if (StringUtils.isBlank(subUrlString)) {
			access = url;
		} else {
			access = url + "/" + subUrlString;
		}
		if (StringUtils.isNotBlank(params)) {
			access = access + "?" + params;
		}
		model.addAttribute("access", access);
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
