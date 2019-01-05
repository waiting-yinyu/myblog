package com.alvin.springbootvue.service;

import com.alvin.springbootvue.entity.User;

/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年1月5日
*/
public interface UserService {
	
	User findByName(String name);
	
	User findAll();
}
