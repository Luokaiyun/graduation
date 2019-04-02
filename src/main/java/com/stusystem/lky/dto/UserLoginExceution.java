package com.stusystem.lky.dto;

import com.stusystem.lky.entity.UserInfo;
import com.stusystem.lky.enums.LoginStateEnum;
public class UserLoginExceution {
	private int userId;
	
	private int state;
	
	private String stateInfo;
	
	private UserInfo userInfo;
	
	public UserLoginExceution(){
		
	}
	
	//登陆失败的构造器
	public UserLoginExceution(int userId,LoginStateEnum loginState){
		this.userId=userId;
		this.state=loginState.getState();
		this.stateInfo=loginState.getStateInfo();
	}
	
	//登陆成功的构造器
	public UserLoginExceution(int userId,LoginStateEnum loginState,UserInfo userInfo){
		this.userId=userId;
		this.state=loginState.getState();
		this.stateInfo=loginState.getStateInfo();
		this.userInfo=userInfo;
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
