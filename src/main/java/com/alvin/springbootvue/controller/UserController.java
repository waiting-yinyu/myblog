package com.alvin.springbootvue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alvin.springbootvue.entity.User;
import com.alvin.springbootvue.service.UserService;

/**
 * @author: 尹宇
 * @mail yinyu@zving.com
 * @date:2019年1月4日
 */

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<User> selectAll() {
		return userService.selectUserAll();
	}

	@RequestMapping(value = "/selectId", method = RequestMethod.GET)
	public User selectId(String id) {
		User user = userService.selectById(Integer.parseInt(id));
		return user;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUser(User user) {
		userService.addUser(user);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public void updateUser(User user) {
		userService.updateUser(user);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteId(String id) {
		userService.deleteUser(Integer.parseInt(id));
	}
}
