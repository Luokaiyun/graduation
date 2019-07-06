package com.stusystem.lky.web;

import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stusystem.lky.dto.UserLoginExceution;
import com.stusystem.lky.entity.UserInfo;
import com.stusystem.lky.enums.LoginStateEnum;
import com.stusystem.lky.exception.NoUserException;
import com.stusystem.lky.exception.WrongPasswordException;
import com.stusystem.lky.service.UserService;

@Controller

public class UserLoginController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login")
	@ResponseBody
	public ModelAndView check(@RequestParam ("userName")String userName, @RequestParam("userPassword") String userPassword){
		
		ModelAndView mv=new ModelAndView();
		
		UserLoginExceution exceution=null;
		int id=userService.getByUserName(userName).getUserId();
		try{
			exceution=userService.userLogin(userName, userPassword);
		}catch(NoUserException e1){
			exceution=new UserLoginExceution(id,LoginStateEnum.NO_USER);
		}catch(WrongPasswordException e2){
			exceution=new UserLoginExceution(id,LoginStateEnum.WRONG_PASSWORD);
		}catch(Exception e){
			exceution=new UserLoginExceution(id,LoginStateEnum.LOGIN_ERROR);
		}
		
		if(exceution.getState()!=1){
			mv.addObject("message",exceution.getStateInfo());
			mv.setViewName("redirect:/jsp/login.jsp");
		}
		else{
			mv.addObject("userName",userName);
			mv.setViewName("forward:/index");
		}
		return mv;
	}
	
	@RequestMapping(value="/register")
	@ResponseBody
	public ModelAndView register(@RequestParam ("userName")String userName, @RequestParam("userPassword") String userPassword){
		ModelAndView mv=new ModelAndView();
		int result=userService.insertUser(userName, userPassword);
		if(result==0){
			String mes="UserAlreadyExits";
			mv.addObject("message",mes);
			mv.setViewName("redirect:/jsp/register.jsp");
		}
		else{
			userService.insertUser(userName, userPassword);
			mv.addObject("userName",userName);
			mv.setViewName("forward:/index");
		}
		return mv;
		
	}
	
}
