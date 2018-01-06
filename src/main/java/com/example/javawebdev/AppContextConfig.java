package com.example.javawebdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
@Import({
	org.springframework.web.servlet.handler.SimpleServletHandlerAdapter.class,
	org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter.class,
})
@ImportAutoConfiguration({
	org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration.class,
	org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration.class,
	org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration.class,
})
public class AppContextConfig {

	public static void main(String[] args) {
		SpringApplication.run(AppContextConfig.class, args);
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
