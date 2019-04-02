package com.stusystem.lky.dao;

import org.apache.ibatis.annotations.Param;

import com.stusystem.lky.entity.UserInfo;

public interface UserInfoDAO {
	/**
	 * 通过用户名查询用户
	 * 
	 * @param userName
	 * @return
	 */
	
    UserInfo queryByName(String userName);
    
    int insertUser(@Param("userName") String userName,@Param("userPassword") String userPassword);

}
