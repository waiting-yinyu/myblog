package com.alvin.springbootvue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.alvin.springbootvue.entity.User;

/**
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年1月4日
*/

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM USER WHERE NAME = #{name}")
	User findByName(@Param("name") String name);
	
	@Select("SELECT * FROM USER")
	User findAll();
}
