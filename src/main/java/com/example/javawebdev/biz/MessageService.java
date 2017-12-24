package com.example.javawebdev.biz;

public class MessageService {

	public String getMessage(String key) {
		return System.getProperty(key);
	}
	
}
