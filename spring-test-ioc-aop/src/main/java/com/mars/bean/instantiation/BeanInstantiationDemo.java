package com.mars.bean.instantiation;

import com.mars.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author doujiang
 * TODO Bean 实例化的方式
 */
public class BeanInstantiationDemo {


	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean-instantiation.xml");

		User user = (User) applicationContext.getBean("user-by-method");
		User user2 = (User) applicationContext.getBean("user-by-static-method");
		User user3 = (User) applicationContext.getBean("user-by-factory-bean");

		System.out.println(user == user2);
		System.out.println(user == user3);
		System.out.println(user2 == user3);
	}
}
