package com.stusystem.lky.enums;

public enum LoginStateEnum {
	SUCESS(1,"LoginSucess"),NO_USER(0,"UserNotExist"),WRONG_PASSWORD(-1,"WrongPassword"),LOGIN_ERROR(-2,"Login error");
	private int state;
	private String stateInfo;
	private LoginStateEnum(int state,String stateInfo){
		this.state=state;
		this.stateInfo=stateInfo;
	}
	
	public int getState(){
		return state;
	}
	
	public String getStateInfo(){
		return stateInfo;
	}
	
	public static LoginStateEnum stateOf(int index){
		for(LoginStateEnum state:values()){
			if(state.getState()==index){
				return state;
			}
		}
		return null;
	}
	
}