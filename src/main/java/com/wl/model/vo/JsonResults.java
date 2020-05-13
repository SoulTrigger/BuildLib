package com.wl.model.vo;

import java.util.AbstractMap;
import java.util.Set;

/**
 * json视图数据
 * @author wuli
 * @date 2019年12月9日下午6:21:49
 */
public class JsonResults extends AbstractMap<String, Object>{

	private Boolean success;
	private String msg;

	public JsonResults(Boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	
	public JsonResults(Boolean success) {
		this.success = success;
	}

	@Override
	public Set<Entry<String, Object>> entrySet() {
		return this.entrySet();
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
