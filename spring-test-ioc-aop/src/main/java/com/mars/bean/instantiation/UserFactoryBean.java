package com.mars.bean.instantiation;

import com.mars.bean.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author doujiang
 * TODO FactoryBean 方式实例化对象
 */
public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		return UserFactory.createUser();
	}


	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
