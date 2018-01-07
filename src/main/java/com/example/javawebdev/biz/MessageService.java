package com.example.javawebdev.biz;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("app.message")
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class MessageService {

//	@Value("${app.message.prefix}")
	protected String prefix;
	
	public String getMessage(String key) {
		String value = System.getProperty(key);
		value = prefix + " " + value;
		return value;
	}
	
}
