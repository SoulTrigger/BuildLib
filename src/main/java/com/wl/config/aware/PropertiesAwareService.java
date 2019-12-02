package com.wl.config.aware;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.wl.model.dto.ProgramException;

/**
 * 加载程序之外的配置文件数据
 * @author wuli
 * @date 2019年10月21日上午9:38:41
 */
@Service
public class PropertiesAwareService implements ResourceLoaderAware {

	private Properties prop;

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		Resource resource = resourceLoader.getResource("classpath:configure.properties");
		Properties prop = new Properties();
		try {
			prop.load(resource.getInputStream());
		} catch (IOException e) {
			throw new ProgramException("加载配置文件失败", e);
		}
		this.prop = prop;
	}

	public Properties getProperties() {
		return prop;
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}
	
}
