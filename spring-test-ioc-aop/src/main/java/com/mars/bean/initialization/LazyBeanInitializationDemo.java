package com.mars.bean.initialization;

import com.mars.bean.instantiation.factory.UserFactory;
import com.mars.bean.instantiation.factory.impl.DefaultUserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @author doujiang
 * TODO Bean 延迟初始化实现方式
 */
public class LazyBeanInitializationDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		// TODO 注册配置类
		applicationContext.register(BeanInitializationDemo.class);

		// TODO 启动 Spring 应用上下文
		applicationContext.refresh();
		System.out.println("spring 应用上下文已启动。。。");

		// TODO 依赖查找
		UserFactory userFactory = applicationContext.getBean(UserFactory.class);
		System.out.println(userFactory);

		// TODO 关闭 Sprig 应用上下文
		applicationContext.close();
	}

	@Lazy(value = true)
	@Bean(initMethod = "initUserFactory")
	public UserFactory userFactory(){
		return new DefaultUserFactory();
	}
}
