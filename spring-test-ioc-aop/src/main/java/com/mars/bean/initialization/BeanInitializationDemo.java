package com.mars.bean.initialization;

import com.mars.bean.instantiation.factory.UserFactory;
import com.mars.bean.instantiation.factory.impl.DefaultUserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author doujiang
 * TODO Bean 的初始化方式
 * TODO 1. 基于 @PostConstruct
 * TODO 2. 基于 initMethod 指定自定义方法
 * TODO 3. 基于 实现 InitializingBean#afterPropertiesSet() 方法实现
 *
 * TODO 如果这三种实现同时存在，执行顺序是什么？
 * 首先执行的是 @PostConstruct
 * 其次执行的是 InitializingBean#afterPropertiesSet()
 * 最后执行的是 initMethod 指定自定义方法
 */
public class BeanInitializationDemo {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		// TODO 注册配置类
		applicationContext.register(BeanInitializationDemo.class);

		// TODO 启动 Spring 应用上下文
		applicationContext.refresh();

		// TODO 依赖查找
		UserFactory userFactory = applicationContext.getBean(UserFactory.class);
		System.out.println(userFactory.createUser());

		// TODO 关闭 Sprig 应用上下文
		applicationContext.close();
	}

	@Bean(initMethod = "initUserFactory")
	public UserFactory userFactory(){
		return new DefaultUserFactory();
	}
}
