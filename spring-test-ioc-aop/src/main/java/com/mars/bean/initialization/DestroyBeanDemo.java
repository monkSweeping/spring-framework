package com.mars.bean.initialization;

import com.mars.bean.instantiation.factory.UserFactory;
import com.mars.bean.instantiation.factory.impl.DefaultUserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author doujiang
 */
public class DestroyBeanDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		// TODO 注册配置类
		applicationContext.register(DestroyBeanDemo.class);

		// TODO 启动 Spring 应用上下文
		applicationContext.refresh();

		// TODO 依赖查找
		UserFactory userFactory = applicationContext.getBean(UserFactory.class);
		System.out.println(userFactory.createUser());

		// TODO 关闭 Sprig 应用上下文
		applicationContext.close();
	}

	@Bean(destroyMethod = "doDestroy")
	public UserFactory userFactory(){
		return new DefaultUserFactory();
	}
}
