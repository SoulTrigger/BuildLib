package com.wl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wl.model.po.MetadataField;
import com.wl.model.vo.JsonResults;
import com.wl.model.vo.PageResults;
import com.wl.service.FieldService;

/**
 * @author wuli
 * @date 2019年12月9日下午5:59:53
 */
@Controller
@RequestMapping("field")
public class FieldController {

	@Autowired
	FieldService fieldService;

	@RequestMapping("toList")
	public String toList() {
		return "field/list";
	}

	@ResponseBody
	@RequestMapping("list")
	public PageResults<MetadataField> list(int pageSize, int pageNumber) {
		PageResults<MetadataField> pager = fieldService.list(pageSize, pageNumber);
		return pager;
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
