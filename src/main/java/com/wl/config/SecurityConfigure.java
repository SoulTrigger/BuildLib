package com.wl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * spring-security相关配置
 * TODO:计划不启用spring-security
 * @author wuli
 * @date 2019年10月21日下午3:29:30
 */
@Configuration
@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").permitAll()
				.anyRequest().authenticated()
				.and()
		        .formLogin()
		        .and()
		        .httpBasic();
	}
}
