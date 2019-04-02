package com.stusystem.lky.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stusystem.lky.entity.NoteInfo;
import com.stusystem.lky.service.NoteService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class NoteController {
	@Autowired
	private NoteService noteService;
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public void saveNote(HttpServletRequest request,HttpServletResponse response,@RequestBody JSONObject jb)throws Exception{
		 NoteInfo insertinfo=new NoteInfo();
		 insertinfo=(NoteInfo)JSONObject.toBean(jb, NoteInfo.class);
		 int insertresult=noteService.insertNote(insertinfo);
		 JSONObject obj1=new JSONObject();
		 if(insertresult==0){
			 //保存成功
			 obj1.put("resultMess", "保存失败"); 
		 }
		 else{
			 obj1.put("resultMess", "保存成功");
		 }
		 response.setContentType("application/json;charset=UTF-8");
		 response.getWriter().write(obj1.toString());	
	}
	
	@RequestMapping(value="/show")
	@ResponseBody
	public ModelAndView showNote(@RequestParam("userName")String userName){
		ModelAndView mv=new ModelAndView();
		List<NoteInfo> noteinfos=noteService.getByUser(userName);
		List<String> notetitle=new ArrayList<String>();
		List<String> notecontent=new ArrayList<String>();
		int len=noteinfos.size();
		for(int i=0;i<len;i++){
			notetitle.add(noteinfos.get(i).getNoteTitle());
			notecontent.add(noteinfos.get(i).getNoteContent());
		}
		JSONArray ja1=JSONArray.fromObject(notetitle);
		JSONArray ja2=JSONArray.fromObject(notecontent);
		mv.addObject("noteTitle",ja1);
		mv.addObject("noteContent",ja2);
		mv.setViewName("showNote");
		return mv;
	}
}
