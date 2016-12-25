package com.example.javawebdev;

import java.io.File;

import org.apache.catalina.startup.Tomcat;

public class App {

	public static void main(String[] args) throws Exception {
		Tomcat tomcat = new Tomcat();
		File webapp = new File("src/main/webapp").getAbsoluteFile();
		tomcat.setBaseDir("tomcat");
		tomcat.addWebapp("", webapp.getPath());
		tomcat.start();
		tomcat.getServer().await();
	}
	
}
