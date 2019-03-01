package com.alvin.springbootvue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.alvin.springbootvue.entity.User;

/**
 * @author: 尹宇
 * @mail yinyu@zving.com
 * @date:2019年1月4日
 */

@Mapper
public interface UserMapper {
	@Select("select * from user")
	List<User> selectUserAll();

	@Select("select * from user where id = #{id}")
	User selectById(int id);

	@Select("select * from user where userName like #{userName}")
	List<User> selectByName(String userName);

	@Insert("insert into user(userName,userAge,userAddress) values (#{userName},#{userAge},#{userAddress})")
	void addUser(User user);

	@Update("update user set userName=#{userName},userAge=#{userAge},userAddress=#{userAddress} where id=#{id}")
	void updateUser(User user);

	@Delete("delete from user where id = #{id}")
	void deleteUser(int id);

	@Select("select * from user where username = #{username}")
	User VerifyUser(String username);
}
