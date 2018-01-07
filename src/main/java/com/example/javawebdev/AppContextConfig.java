package com.example.javawebdev;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
@Import({
	org.springframework.context.support.PropertySourcesPlaceholderConfigurer.class,
	org.springframework.web.servlet.handler.SimpleServletHandlerAdapter.class,
	org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter.class,
})
@EnableConfigurationProperties
public class AppContextConfig {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
