package com.alvin.springbootvue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alvin.springbootvue.entity.User;
import com.alvin.springbootvue.service.RedisService;
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
	
	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<User> selectAll() {
		System.out.println("断点");
		return userService.selectUserAll();
	}

	@RequestMapping(value = "/selectId", method = RequestMethod.GET)
	public User selectId(String id) {
		User res = (User)redisService.get(id);
		return res;
		/*User user = userService.selectById(Integer.parseInt(id));
		return user;*/
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(String userName,String userAge,String userAddress) {
//		User user = new User(id, userName, userAge, userAddress);
		User user = new User();
		user.setUserAge(userAge);
		user.setUserName(userName);
		user.setUserAddress(userAddress);
		redisService.set(1 + "", user.getUserName());
		return "success";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public void updateUser(User user) {
		userService.updateUser(user);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteId(String id) {
		userService.deleteUser(Integer.parseInt(id));
	}

	@RequestMapping(value = "/selectByName", method = RequestMethod.GET)
	public List<User> selectByName(String userName) {
		return userService.selectByName("%" + userName + "%");
	}
	
}
