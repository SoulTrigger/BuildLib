package com.wl.model.vo;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import net.bytebuddy.asm.Advice.This;

/**
 * json视图数据
 * @author wuli
 * @date 2019年12月9日下午6:21:49
 */
public class JsonResults extends AbstractMap<String, Object>{

	private Boolean success;
	private String msg;
	private Map<String, Object> attachMap;

	public JsonResults(Boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	
	public JsonResults(Boolean success) {
		this.success = success;
	}
	public JsonResults() {
		this.success = true;
	}
	
	private Map<String, Object> delegate()  {
		if (attachMap==null) {
			attachMap = new HashMap<>();
			attachMap.put("success", success);
			if (msg!=null&&!msg.isEmpty()) {
				attachMap.put("msg", msg);
			}
		}
		return attachMap;
	}
	
	@Override
	public Object put(String key, Object value) {
		return delegate().put(key, value);
	}

	@Override
	public Set<Entry<String, Object>> entrySet() {
		return delegate().entrySet();
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
