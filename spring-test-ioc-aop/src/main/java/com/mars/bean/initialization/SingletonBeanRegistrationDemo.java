package com.mars.bean.initialization;

import com.mars.bean.instantiation.factory.UserFactory;
import com.mars.bean.instantiation.factory.impl.DefaultUserFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author doujiang
 */
public class SingletonBeanRegistrationDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		// TODO 创建一个外部对象,并将该对象加入到Spring
		UserFactory userFactory = new DefaultUserFactory();

		// TODO 获取到BeaFactory
		SingletonBeanRegistry registry = applicationContext.getBeanFactory();

		// TODO 注册外部对象
		registry.registerSingleton("userFactory",userFactory);

		// TODO 启动IOC 容器
		applicationContext.refresh();

		// TODO 通过依赖查找获取UserFactory
		UserFactory userFactory1 = applicationContext.getBean("userFactory",UserFactory.class);

		//TODO 判断这两个对象是否相等
		System.out.println(userFactory == userFactory1); // true

		// TODO 关闭IOC 容器
		applicationContext.close();
	}
}
