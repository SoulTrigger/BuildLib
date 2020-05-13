package com.wl.config.interceptor;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.wl.base.BaseService;
import com.wl.model.po.Role;

@Component
public class AppFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private BaseService<Role, String> roleService;
	private Map<String, Collection<ConfigAttribute>> map = null;
	
	/**
	 * 加载权限资源
	 * @Author:wuli
	 * @Description:
	 */
	public void loadResourceDefine() {
		map = new HashMap<>(16);
		List<Role> roles = roleService.getListByHQL("form Role");
		for (Role role : roles) {
			
		}
	}
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

}
