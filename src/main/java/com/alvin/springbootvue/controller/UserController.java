package com.alvin.springbootvue.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvin.springbootvue.entity.User;

/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年1月4日
*/

@RestController
public class UserController {
	@RequestMapping("/getUser")
	public User getUser(){
		User user = new User("zhangsan","123456",27);
		return user;
	}
}
