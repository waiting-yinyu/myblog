package com.alvin.springbootvue.service.Impl;

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
	public User findByName(String name) {
		return userMapper.findByName(name);
	}

	@Override
	public User findAll() {
		return userMapper.findAll();
	}
	
}
