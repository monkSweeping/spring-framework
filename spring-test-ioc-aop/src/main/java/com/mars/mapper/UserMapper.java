package com.mars.mapper;

import com.mars.bean.User;

/**
 * @author jsq
 */
public interface UserMapper {

	/**
	 * 添加
	 * @param user
	 * @return
	 */
	int addUser(User user);
}
