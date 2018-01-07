package com.example.javawebdev;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

/**
 * 实现说明：spring boot 自动读取配置文件，不需要此配置。 
 */
public class AppPlaceholderConfig extends ApplicationObjectSupport {
	
	/**
	 * YAML {@link Properties} 原型 bean。<br/>
	 * 此原型 bean 实例化返回 FactoryBean， spring 进一步处理后得到 Properties。<p/>
	 * 
	 * 返回类型只能使用 Object：
	 * <ul>
	 * 	<li>bean 类型是 Properties，但 Java 代码层面是返回 FactoryBean，返回类型不能用 Properties。</li>
	 * 	<li>此处 FactoryBean 是原型 bean 实例化的结果 bean，不是用 FactoryBean 定义 bean，返回类型不能用 FactoryBean。</li>
	 * 	<li>实际上 spring 会对此方法进行增强，增强后将自动把 FactoryBean 转为 bean，即增强后的返回对象确实是 Properties。</li>
	 * 	<li>注解已经说明此 bean scope　类型，结果 bean FactoryBean 的 <code>isSingleton()</code> 无实际意义（？）。</li>
	 * </ul>
	 */
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Object yamlPropertiesPrototype(Resource resource) {
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(resource);
		return yaml;
	}

	/**
	 * 实例化一个 {@link #yamlPropertiesPrototype(Resource)} 原型 bean。<p/>
	 * 实现说明：<br/>
	 * <ul>
	 * 	<li>不能使用 {@link org.springframework.beans.factory.annotation.Lookup} 注解。
	 * 此方法被 {@link #propertySourcesPlaceholderConfigurer(Resource)} bean 依赖，
	 * 其为 BeanFactoryPostProcessor，最早被创建，注解相关 PostProcessor 等还未创建，其及其依赖不能使用相关注解。</li>
	 * 	<li>最早调用此方法时，spring 容器功能还未完备，未能充分使用容器组装功能，但仍然使得此 bean 被容器管理。</li>
	 * </ul>
	 */
	public Properties getYamlProperties(Resource resource) {
		Object bean = getApplicationContext().getBean("yamlPropertiesPrototype", resource);
		return (Properties) bean;
	}
	
	/**
	 * 实现说明：<br/>
	 * <ul>
	 * 	<li>此 bean 是 BeanFactoryPostProcessor，最早被创建，spring 容器功能还未完备。</li>
	 * 	<li>作为容器基础设施的功能组件，应不要依赖注解等高级功能，可使用基础容器支持的相关接口等。
	 * 如使用 {@link org.springframework.beans.factory.InitializingBean} 代替 {@link javax.annotation.PostConstruct}。</li>
	 * 	<li>为减少创建基础组件的影响，如其依赖 configuration 组件应避免使用相关注解（测试 <code>@Autowired</code> 注解最终也未生效？），应将其及其必须依赖移动到单独的配置中。</li>
	 * </ul>
	 */
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(@Value("classpath:application.yml") Resource resource) {
		PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
		Properties prop = getYamlProperties(resource);
		config.setProperties(prop);
		return config;
	}

}
