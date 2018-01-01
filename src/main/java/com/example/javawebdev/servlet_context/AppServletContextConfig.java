package com.example.javawebdev.servlet_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppServletContextConfig {

	public static class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
		
		@Override
		protected Class<?>[] getRootConfigClasses() {
			// 不创建 root ApplicationContext
			return null;
		}

		protected Class<?>[] servletConfigClasses = { com.example.javawebdev.AppContextConfig.class, };
		
		@Override
		protected Class<?>[] getServletConfigClasses() {
			return servletConfigClasses;
		}

		protected String[] servletMappings = { "/*", };

		@Override
		protected String[] getServletMappings() {
			return servletMappings;
		}

	}
	
	public static class JspServletInitializer implements WebApplicationInitializer {

		public static final String TomcatJspServletName = "jsp";
		
		@Override
		public void onStartup(ServletContext servletContext) throws ServletException {
			ServletRegistration reg = servletContext.getServletRegistration(TomcatJspServletName);
			reg.addMapping("/WEB-INF/jsp/*");
		}
		
	}

}
