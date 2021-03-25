package com.mars.service;

import com.mars.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author doujiang
 */
@Repository
public interface UserService {

	/**
	 * 添加
	 * @param user
	 * @return
	 */
	int addUser(User user);
}
