package com.wl.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * web.xml项目启动项配置
 * @author wuli
 * @date 2019年10月21日下午3:41:05
 */
public class WebInitializer extends AbstractSecurityWebApplicationInitializer{
	
	/**
	 * spring security注册之前，注册spring mvc
	 */
	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MvcConfigure.class);
		ctx.setServletContext(servletContext);

		//动态创建servlet替代相关配置
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
	
}
