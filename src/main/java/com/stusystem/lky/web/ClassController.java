package com.stusystem.lky.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stusystem.lky.entity.ClassInfo;
import com.stusystem.lky.entity.NoteInfo;
import com.stusystem.lky.service.UserService;
import com.stusystem.lky.service.getClassService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class ClassController {
	
	@Autowired
	private getClassService classService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getclass")
	@ResponseBody
	public ModelAndView getClass(HttpServletRequest request,String chapterId){
		
		ModelAndView mv=new ModelAndView();
		int chapterid=Integer.parseInt(chapterId);
		List<ClassInfo> classInfo=new ArrayList<ClassInfo>();
		classInfo=classService.getBychapterId(chapterid);

		//Map<String,Object>map=null;
		//List<Map<String,Object>>maplist=new ArrayList<Map<String, Object>>();
		List<String> className=new ArrayList<String>();
		List<String> classContent=new ArrayList<String>();
		List<Integer>classId=new ArrayList<Integer>();
		for(int i=0;i<classInfo.size();i++){
			className.add(classInfo.get(i).getClassName());
			classContent.add(classInfo.get(i).getClassContent());
			classId.add(classInfo.get(i).getknowId());
		}
		JSONArray ja1=JSONArray.fromObject(className);
		JSONArray ja2=JSONArray.fromObject(classContent);
		JSONArray ja3=JSONArray.fromObject(classId);
		mv.addObject("className",ja1);
		mv.addObject("classContent",ja2);
		mv.addObject("classId",ja3);
		//mv.addObject("classInfo", maplist);
		mv.setViewName("chapter");
		return mv;
		
	}
	
	@RequestMapping(value="/userClassState")
	public void setuserClassState(HttpServletRequest request,HttpServletResponse response,@RequestBody JSONObject jb)throws Exception{
		int classId=jb.getInt("classId");
		String userName=jb.getString("userName");
		int userId=userService.getByUserName(userName).getUserId();
		int resultcode=classService.insertUserClass(classId, userId);
		JSONObject obj1=new JSONObject();
		 if(resultcode==0){
			 //保存成功
			 obj1.put("resultMess", "保存失败"); 
		 }
		 else{
			 obj1.put("resultMess", "保存成功");
		 }
		 response.setContentType("application/json;charset=UTF-8");
		 response.getWriter().write(obj1.toString());	
	}
}
