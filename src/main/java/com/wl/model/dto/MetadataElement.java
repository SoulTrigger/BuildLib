package com.wl.model.dto;


/**
 * html元素类型
 * @author wuli
 * @date 2019年10月24日下午3:58:45
 */
public enum MetadataElement {
	
	INPUT_TEXT(1,"文本框"),
	INPUT_RADIO(2,"单选框"),
	INPUT_CHECKBOX(3,"复选框"),
	TEXTAREA(4,"富文本框"),
	SELECT(5,"下拉框");
	
	private int code;
	private String alis;
	MetadataElement(int code,String alis) {
		this.code = code;
		this.alis = alis;
	}
	
}
