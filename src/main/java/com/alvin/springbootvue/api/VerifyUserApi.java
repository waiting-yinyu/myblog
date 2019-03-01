package com.alvin.springbootvue.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author: 尹宇
 * @mail yinyu@zving.com
 * @date:2019年3月1日
 */
@RestController
@RequestMapping(value = "/user")
public class VerifyUserApi {
	@ApiOperation(value = "用户校验接口")
	@GetMapping(value = "/verifyUser")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "用户名", required = true, example = "admin", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, example = "admin", dataType = "String", paramType = "query") })
	public boolean verifyUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equals("admin") && password.equals("admin")) {
			return true;
		} else {
			return false;
		}
	}
}
