package com.example.javawebdev;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AppRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) event.getApplicationContext();
		LinkedHashMap<String, Object> beanMap = new LinkedHashMap<>();
		Iterator<String> iter = ctx.getBeanFactory().getBeanNamesIterator();
		for (String name; iter.hasNext();) {
			name = iter.next();
			boolean prototype = false;
			try {
				BeanDefinition def = ctx.getBeanFactory().getBeanDefinition(name);
				prototype = def.isPrototype();
			} catch (Exception e) {
				// pass
			}
			Object bean;
			if (prototype) {
				bean = "<<---- PROTOTYPE ---->>";
			} else {
				bean = ctx.getBean(name);
			}
			beanMap.put(name, bean);
		}
		for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		System.out.println("bean count: " + beanMap.size());
	}

}
