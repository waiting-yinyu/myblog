package com.alvin.springbootvue.entity;

import java.io.Serializable;

import com.alvin.springbootvue.code.ResultCode;

import lombok.Data;

/**
 * RESTFul 响应封装类
 * 
 * @author: 尹宇
 * @mail yinyu@zving.com
 * @date:2019年3月1日
 */

@Data
public class Result implements Serializable {
	private static final long serialVersionUID = -3948389268046368059L;

	private Integer code;

	private String message;

	private Object data;

	public Result() {}

	public Result(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public static Result success() {
		Result result = new Result();
		result.setResultCode(ResultCode.SUCCESS);
		return result;
	}

	public static Result success(Object data) {
		Result result = new Result();
		result.setResultCode(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}

	public static Result failure(ResultCode resultCode) {
		Result result = new Result();
		result.setResultCode(resultCode);
		return result;
	}

	public static Result failure(ResultCode resultCode, Object data) {
		Result result = new Result();
		result.setResultCode(resultCode);
		result.setData(data);
		return result;
	}

	public void setResultCode(ResultCode code) {
		this.code = code.code();
		this.message = code.message();
	}
}
