package com.mars.ioc;

import com.mars.bean.User;
import com.mars.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author doujiang
 */
public class IocTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.mars");
		annotationConfigApplicationContext.refresh();
		UserService userService = (UserService) annotationConfigApplicationContext.getBean("userService");
		userService.addUser(new User());
	}
}
