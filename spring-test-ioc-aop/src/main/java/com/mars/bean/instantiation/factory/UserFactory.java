package com.mars.bean.instantiation.factory;

import com.mars.bean.User;

/**
 * @author doujiang
 */
public interface UserFactory {


	default User createUser(){
		return com.mars.bean.instantiation.UserFactory.createUser();
	}
}
