package com.wl.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wl.config.aware.PropertiesAwareService;
import com.wl.config.interceptor.RequestTimeIntercepter;
import com.wl.model.dto.ProgramException;

/**
 * WebMvcConfigurerAdapter需要定制配置
 * @Author:wuli
 * @Description:
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan("com.wl")
@Import(SecurityConfigure.class)
public class MvcConfigure extends WebMvcConfigurerAdapter implements TransactionManagementConfigurer{
	
	//注入文件资源
	@Autowired
	private PropertiesAwareService propService;
	
	
	/**
	 * @return
	 * @Author:wuli
	 * @Description:视图解析
	 */
	@Bean
	public InternalResourceViewResolver viewResolever() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/classes/views/");
		view.setSuffix(".jsp");
		view.setViewClass(JstlView.class);
		return view;
	}
	
	/**
	 * 映射静态资源
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//addResourceHandler对外访问的路径
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}
	
	/**
	 * 简化跳转
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("login").setViewName("login");
		registry.addViewController("toUpload").setViewName("upload");
	}
	
	
	/**
	 * spring拦截器集合
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestTimeIntercepter());
	}
	
	/**
	 * @return
	 * @Author:wuli
	 * @Description:上传文件大小限制
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(104857600);
		resolver.setMaxInMemorySize(4096);
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}
	
	/**
	 * @return
	 * @throws IOException
	 * @throws PropertyVetoException
	 * @Author:wuli
	 * @Description:定义postgresql数据源
	 */
	@Bean(destroyMethod = "close")
	public ComboPooledDataSource dataSource() throws IOException, PropertyVetoException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass(propService.getProperty("db.driver"));
		ds.setJdbcUrl(propService.getProperty("db.url"));
		ds.setUser(propService.getProperty("db.user"));
		ds.setPassword(propService.getProperty("db.password"));
		ds.setMaxIdleTime(Integer.parseInt(propService.getProperty("db.maxIdleTime")));
		return ds;
	}
	
	/**
	 * @return
	 * @throws IOException
	 * @throws PropertyVetoException
	 * @Author:wuli
	 * @Description:定义hibernate的sessionFactory
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws IOException, PropertyVetoException {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//		ImplicitNamingStrategyJpaCompliantImpl：默认的命名策略
//		factoryBean.setImplicitNamingStrategy(ImplicitNamingStrategyComponentPathImpl.INSTANCE);
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("com.wl.model.po");
		Properties hibernateProperties = new Properties();
		for (Object key : propService.getProperties().keySet()) {
			hibernateProperties.put(key, propService.getProperty(key.toString()));
		}
		factoryBean.setHibernateProperties(hibernateProperties);
		return factoryBean;
	}
	
	/**
	 * @return
	 * @throws IOException
	 * @throws PropertyVetoException
	 * @Author:wuli
	 * @Description:定义hibernate事务管理
	 */
	@Bean
	public HibernateTransactionManager transactionManager() throws IOException, PropertyVetoException {
		return new HibernateTransactionManager(sessionFactory().getObject());
	}

	/**
	 * 将hibernate事务管理交给spring管理
	 */
	@Bean
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		try {
			return transactionManager();
		} catch (IOException | PropertyVetoException e) {
			throw new ProgramException("创建hibernate事务失败", e);
		}
	}
	 
}
