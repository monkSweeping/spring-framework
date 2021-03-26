package com.mars.bean.instantiation;

import com.mars.bean.User;

/**
 * @author doujiang
 */
public class UserFactory {


	/**
	 * 静态方法实例化
	 * @return
	 */
	public static User createUser(){
		return new User();
	}

	/**
	 * 实例化方法实例化Bean
	 * @return
	 */
	public User create(){
		return new User();
	}

}
