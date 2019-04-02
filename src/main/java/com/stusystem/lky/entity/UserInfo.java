package com.stusystem.lky.entity;



public class UserInfo {
	private int userId;//用户id
	
	
	private String userName;//用户名
	
	
	private String userPassword;//用户密码
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String toString(){
		
		return "UserInfo[userId"+userId+",userName="+userName+", password="+userPassword+"]";
		
	}
	

}
