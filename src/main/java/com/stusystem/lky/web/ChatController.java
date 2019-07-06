package com.stusystem.lky.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stusystem.lky.entity.ChatAns;
import com.stusystem.lky.entity.ChatProblem;
import com.stusystem.lky.service.ChatService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@RequestMapping(value="/getProblem")
	@ResponseBody
	public ModelAndView getProblem(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		List<ChatProblem> problems=chatService.getAll();
		//JSONObject obj=new JSONObject();
		List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
		Map<String,Object> map=null;
		if(problems.size()==-0){
			mv.addObject("problems",0);
		}
		else{
			for(int i=0;i<problems.size();i++){
				map=new LinkedHashMap<String,Object>();
				map.put("problemId", problems.get(i).getProblemId());
				map.put("problemContent", problems.get(i).getProblemContent());
				map.put("problemAuthor", problems.get(i).getProblemAuthor());
				maplist.add(map);
			}
			JSONArray obj=JSONArray.fromObject(maplist);
			mv.addObject("problems",obj);
		}
		mv.setViewName("chat");
		return mv;
	}

	@RequestMapping(value="/getDetailAns")
	@ResponseBody
	public ModelAndView getDetailAns(HttpServletRequest request,int problemId){
		ModelAndView mv=new ModelAndView();
		List<ChatAns>anslist=chatService.getProAns(problemId);
		List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
		Map<String,Object> map=null;
		if(anslist.size()==0){
			mv.addObject("anslist",0);
		}
		else{
			for(int i=0;i<anslist.size();i++){
				map=new LinkedHashMap<String,Object>();
				map.put("ansContent", anslist.get(i).getProblemAns());
				map.put("ansAuthor", anslist.get(i).getAnsAuthor());
				maplist.add(map);
			}
			JSONArray obj=JSONArray.fromObject(maplist);
			mv.addObject("anslist",obj);
		}
		mv.setViewName("detailchat");
		return mv;
	}
	
	@RequestMapping(value="/insertProblem",method=RequestMethod.POST)
	@ResponseBody
	public int insertProblem(HttpServletRequest request,@RequestBody JSONObject json)throws Exception{
		String problemContent=json.getString("problemContent");
		String author=json.getString("author");
		//String resultStr="插入成功";
		int result=chatService.insertPro(problemContent, author);
		//if(result==-1){
			//resultStr="插入失败";
		//}
		return result;
	}
	
	@RequestMapping(value="/insertAns",method=RequestMethod.POST)
	@ResponseBody
	public int insertAns(HttpServletRequest request,@RequestBody JSONObject json)throws Exception{
		//String resultStr="保存成功";
		String ansContent=json.getString("ansContent");
		int problemId=json.getInt("problemId");
		String author=json.getString("author");
		int result=chatService.insertAns(problemId, ansContent, author);
		//if(result==-1){
			//resultStr="保存失败";
		//}
		return result;
	}
}
