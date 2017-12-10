package com.example.javawebdev.servlet_container;

import java.io.File;

import org.apache.catalina.startup.Tomcat;

public class TomcatBootstrap {

	public static void main(String[] args) throws Exception {
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir("target/tomcat");
		tomcat.getHost().setAutoDeploy(false);
		File webapp = new File("src/main/webapp").getAbsoluteFile();
		tomcat.addWebapp("", webapp.getPath());
		tomcat.start();
		tomcat.getServer().await();
	}
	
}
