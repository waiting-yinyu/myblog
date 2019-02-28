package com.alvin.springbootvue.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年2月28日
*/

@RestController
@RequestMapping(value= "/test")
public class TestApi {
	@ApiOperation(value= "测试swagger2集成")
	@GetMapping(value="/getValue")
	public String getValue() {
		return "success";
	}
}
