package com.stusystem.lky.web;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public String ValidationException(ConstraintViolationException e){
		for(ConstraintViolation<?> s:e.getConstraintViolations()){
			return s.getInvalidValue()+":"+s.getMessage();
		}
		return "wrong";
	}
}
