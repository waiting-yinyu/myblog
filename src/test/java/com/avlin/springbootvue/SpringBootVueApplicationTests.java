package com.avlin.springbootvue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alvin.springbootvue.SpringBootVueApplication;
import com.alvin.springbootvue.entity.User;
import com.alvin.springbootvue.mapper.UserMapper;

/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年1月4日
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootVueApplication.class)
public class SpringBootVueApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void findByName() throws Exception {
//		User user = userMapper.findByName("lisi");
//		Assert.assertEquals(22, user.getAge());
	}
}
