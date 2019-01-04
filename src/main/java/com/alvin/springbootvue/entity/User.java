package com.alvin.springbootvue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年1月4日
*/

@Data
@AllArgsConstructor
public class User {
	private String name;
	private String password;
	private int age;
}
