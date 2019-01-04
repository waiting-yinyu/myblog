package com.alvin.springbootvue.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvin.springbootvue.entity.User;
import com.alvin.springbootvue.mapper.UserMapper;

/**
 * @author: 尹宇
 * @mail yinyu@zving.com
 * @date:2019年1月4日
 */

@RestController
public class UserController {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/getAllUser")
	public User getAllUser() {
		return userMapper.findAll(); 
	}
	
	@RequestMapping("/getUserByName")
	public User getUserByName(String name){
		return userMapper.findByName(name);
	}
}
