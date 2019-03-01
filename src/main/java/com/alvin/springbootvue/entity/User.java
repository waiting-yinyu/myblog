package com.alvin.springbootvue.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年1月4日
*/

@Data
@NoArgsConstructor
public class User {
	private int id;
	private String username;
	private String password;
	private Date addtime;
	private String adduser;
}
