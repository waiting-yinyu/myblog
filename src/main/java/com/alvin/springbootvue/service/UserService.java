package com.alvin.springbootvue.service;

import java.util.List;

import com.alvin.springbootvue.entity.User;

/**
 * @author: 尹宇
 * @mail yinyu@zving.com
 * @date:2019年1月5日
 */
public interface UserService {

	List<User> selectUserAll();

	User selectById(int id);

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(int id);
}
