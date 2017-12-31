package com.example.javawebdev.biz;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class MessageService {

	protected String prefix;
	
	public String getMessage(String key) {
		String value = System.getProperty(key);
		value = prefix + " " + value;
		return value;
	}
	
}
