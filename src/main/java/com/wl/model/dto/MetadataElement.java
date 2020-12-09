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
	SELECT(5,"下拉框"),
	INPUT_FILE(6,"文本域");
	
	private int code;
	private String alias;
	MetadataElement(int code,String alias) {
		this.code = code;
		this.alias = alias;
	}
	public int getCode() {
		return code;
	}
	public String getAlias() {
		return alias;
	}
	
}
