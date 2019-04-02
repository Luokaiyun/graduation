package com.stusystem.lky.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping(value="/index") 
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){ 
		ModelAndView mv=new ModelAndView();
		String userName="";
		userName=userName+request.getParameter("userName");
		mv.addObject("userName",userName);
		mv.setViewName("index");
		return mv ; 
	}

}
