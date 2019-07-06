package com.stusystem.lky.service;
import com.stusystem.lky.entity.UserInfo;
import com.stusystem.lky.dto.UserLoginExceution;
public interface UserService {
	UserInfo getByUserName(String userName);
	
	UserLoginExceution userLogin(String userName,String userPassword);
	
	int insertUser(String userName,String password);
}
