package com.stusystem.lky.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stusystem.lky.entity.QuestionInfo;
import com.stusystem.lky.service.ExamService;

import net.sf.json.JSONObject;

@Controller
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	List<QuestionInfo> exam=new ArrayList<QuestionInfo>();
	
	@RequestMapping(value="/getExam")
	@ResponseBody
	public ModelAndView getExam(HttpServletRequest request,JSONObject json){
		ModelAndView mv=new ModelAndView();
		String userName=json.getString("userName");
		List<Integer> knowId=examService.getUserlearnedClass(userName);
		//handle里存放用户每章的掌握程度（小数）
		List<Integer> handle=examService.UserhandlePer(knowId);
		List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
		Map<String,Object> map=null;
		for(int i=0;i<handle.size();i++){
			int per=handle.get(i);
			if(per!=0){
				//要获取的i+1章节题目数
				int count=per*50;
				List<QuestionInfo> ques=examService.queryByChapterId(i+1);
				if(ques.size()>count){
					ques.subList(0, count-1);
				}
				//组成试卷
				exam.addAll(ques);
			}
		}
		for(int j=0;j<exam.size();j++){
			map=new LinkedHashMap<String,Object>();
			map.put("quesId",exam.get(j).getQuestionId());
			map.put("quesContent", exam.get(j).getContent());
			map.put("optionA", exam.get(j).getOption1());
			map.put("optionB",exam.get(j).getOption2());
			map.put("optionC",exam.get(j).getOption3());
			map.put("optionD",exam.get(j).getOption4());
			maplist.add(map);
		}
		JSONObject examjb=JSONObject.fromObject(maplist);
		mv.addObject("examInfo", examjb);
		mv.setViewName("exam");
		return mv;
		//List<QuestionInfo> exam=examService.queryByChapterId(chapterId)
	}

}
