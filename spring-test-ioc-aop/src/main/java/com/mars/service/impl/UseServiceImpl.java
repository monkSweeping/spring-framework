package com.mars.service.impl;

import com.mars.bean.User;
import com.mars.mapper.UserMapper;
import com.mars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author doujiang
 */
@Service("userService")
public class UseServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int addUser(User user) {
		return userMapper.addUser(user);
	}
}
