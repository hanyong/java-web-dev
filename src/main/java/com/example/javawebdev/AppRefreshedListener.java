package com.example.javawebdev;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;

public class AppRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) event.getApplicationContext();
		LinkedHashMap<String, Object> beanMap = new LinkedHashMap<>();
		Iterator<String> iter = ctx.getBeanFactory().getBeanNamesIterator();
		for (String name; iter.hasNext();) {
			name = iter.next();
			Object bean = ctx.getBean(name);
			beanMap.put(name, bean);
		}
		for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		System.out.println("bean count: " + beanMap.size());
	}

}
