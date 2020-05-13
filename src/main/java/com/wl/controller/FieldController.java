package com.wl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wl.base.BaseService;
import com.wl.model.po.MetadataField;
import com.wl.model.vo.JsonResults;

/**
 * @author wuli
 * @date 2019年12月9日下午5:59:53
 */
@Controller
@RequestMapping("field")
public class FieldController {

	@Autowired
	BaseService<MetadataField, String> fieldService;

	@RequestMapping("toList")
	public String toList() {
		return "field/list";
	}

	@RequestMapping("toEdit")
	public String toEdit(Model model, String id) {
		MetadataField fieldObj = null;
		if (StringUtils.isEmpty(id)) {
			fieldObj = new MetadataField();
		} else {
			fieldObj = fieldService.get(id);
		}
		model.addAttribute("data", fieldObj);
		return "field/edit";
	}

	@RequestMapping(value = "edit", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public MetadataField editData(String id) {
		return fieldService.get(id);
	}

	@RequestMapping(value = "save", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public JsonResults saveData(MetadataField field) {
		fieldService.saveOrUpdate(field);
		return new JsonResults(true);
	}
}
