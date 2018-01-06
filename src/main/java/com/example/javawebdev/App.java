package com.example.javawebdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Spring Boot 应用入口。<p/>
 * 
 * 实现注意：不要添加组件注解，防止非 Spring Boot 下被使用。
 */
@ImportAutoConfiguration({
	org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration.class,
	org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration.class,
	org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration.class,
})
@Import({
	com.example.javawebdev.AppContextConfig.class,
})
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
}
