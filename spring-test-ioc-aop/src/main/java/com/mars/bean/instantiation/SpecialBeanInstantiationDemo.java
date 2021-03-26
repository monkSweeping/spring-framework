package com.mars.bean.instantiation;

import com.mars.bean.instantiation.factory.UserFactory;
import com.mars.bean.instantiation.factory.impl.DefaultUserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author doujiang
 * TODO 特殊方式实例化Bean
 */
public class SpecialBeanInstantiationDemo {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:special-bean-instantiation.xml");

		// TODO Spring ServiceLoader
		Object serviceLoader = applicationContext.getBean("userFactoryServiceLoader");
		System.out.println(serviceLoader);

		// TODO JDK ServiceLoader
		serviceLoaderLoadByJDk();

		// TODO Spring AutowireCapableBeanFactory
		AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
		createBeanByAutowireCapableBeanFactory(autowireCapableBeanFactory);

	}

	/**
	 * TODO 通过 JDK ServiceLoader 方式实例化Ben
	 * TODO 该方式只会加载 META-INF.services 下文件定义的实现 并且去重
	 */
	public static void serviceLoaderLoadByJDk() {
		ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
		Iterator<UserFactory> iterator = serviceLoader.iterator();
		while (iterator.hasNext()) {
			UserFactory userFactory = iterator.next();
			System.out.println(userFactory.createUser());
		}
	}

	/**
	 * TODO  该方式只会加载 META-INF.services 下文件定义的实现并返回读取到的第一个实现
	 * TODO  当然 Spring 也提供了返回列表的实现 @link {org.springframework.beans.factory.serviceloader.ServiceListFactoryBean}
	 *
	 * @param serviceLoader
	 */
	public static void serviceLoaderLoadBySpring(ServiceLoader<UserFactory> serviceLoader) {
		Iterator<UserFactory> iterator = serviceLoader.iterator();
		while (iterator.hasNext()) {
			UserFactory userFactory = iterator.next();
			System.out.println(userFactory.createUser());
		}
	}

	/**
	 * TODO 通过 Spring AutowireCapableBeanFactory 实现 Bean的实例化
	 * @param autowireCapableBeanFactory
	 */
	public static void createBeanByAutowireCapableBeanFactory(AutowireCapableBeanFactory autowireCapableBeanFactory) {
		UserFactory userFactory = autowireCapableBeanFactory.createBean(DefaultUserFactory.class);
		System.out.println(userFactory.createUser());
	}
}
