package com.alvin.springbootvue.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvin.springbootvue.entity.User;
import com.alvin.springbootvue.mapper.UserMapper;
import com.alvin.springbootvue.service.UserService;

/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年1月5日
*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> selectUserAll() {
		return userMapper.selectUserAll();
	}

	@Override
	public User selectById(int id) {
		User user = userMapper.selectById(id);
        return user;
	}

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		userMapper.deleteUser(id);
	}
}
