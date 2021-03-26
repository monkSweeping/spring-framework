package com.mars.bean.definition;

import com.mars.bean.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import java.util.Map;

/**
 * @author doujiang
 * TODO 注册 BeanDefinition 到 IOC 容器的三种方式
 */
public class BenDefinitionDemo {


	@Bean(name = "user")
	public User user(){
		return new User();
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		// TODO 方式一 加载配置类 ConfigrationClass
		applicationContext.register(BenDefinitionDemo.class);

		// TODO 方式二 命名方式注册Bean
		registerBeanDefinition(applicationContext,"user-mars", User.class);

		// TODO 方式三 非命名方式注册Bean
		registerBeanDefinition(applicationContext,User.class);

		// TODO 启动容器
		applicationContext.refresh();

		// TODO 获取 User Bean
		Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);
		System.out.println(beansOfType);
	}


	/**
	 * 命名方式注册Bean
	 * @param beanDefinitionRegistry
	 * @param benName
	 * @param beanClass
	 */
	public static void registerBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry,String benName,Class<?> beanClass){
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
		beanDefinitionBuilder.addPropertyValue("userName","mars1");
		beanDefinitionBuilder.addPropertyValue("password","123456");
		beanDefinitionRegistry.registerBeanDefinition(benName,beanDefinitionBuilder.getBeanDefinition());
	}

	/**
	 * f非命名方式注册Bean
	 * @param beanDefinitionRegistry
	 * @param beanClass
	 */
	public static void registerBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry,Class<?> beanClass){
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
		beanDefinitionBuilder.addPropertyValue("userName","mars2");
		beanDefinitionBuilder.addPropertyValue("password","111111");
		BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),beanDefinitionRegistry);
	}
}
