package com.example.javawebdev.biz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class MessageService {

	@Value("${app.message.prefix}")
	protected String prefix;
	
	public String getMessage(String key) {
		String value = System.getProperty(key);
		value = prefix + " " + value;
		return value;
	}
	
}
