package com.stusystem.lky.exception;

public class NoUserException extends RuntimeException {
	public NoUserException(String message){
		super(message);
	}
	public NoUserException(String message,Throwable cause){
		super(message,cause);
	}

}
