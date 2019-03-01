package com.alvin.springbootvue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alvin.springbootvue.entity.User;

/**
 * @author: 尹宇
 * @mail yinyu@zving.com
 * @date:2019年1月5日
 */
@Service
public interface UserService {

	List<User> selectUserAll();

	User selectById(int id);

	List<User> selectByName(String userName);

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(int id);

	User VerifyUser(String username);
}
