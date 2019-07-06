package com.stusystem.lky.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.stusystem.lky.entity.Ans;
import com.stusystem.lky.entity.Exam;
import com.stusystem.lky.entity.ExamList;
import com.stusystem.lky.entity.QuestionInfo;
import com.stusystem.lky.entity.RightId;
import com.stusystem.lky.service.ExamService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class ExamController {
	
	@Autowired
	private ExamService examService;
	ExamList examlist=new ExamList();
	RightId ri=new RightId();
	Exam saveExamInfo=new Exam();
	
	@RequestMapping(value="/getExam")
	@ResponseBody
	public ModelAndView getExam(HttpServletRequest request,@RequestParam("userName")String userName){
		ModelAndView mv=new ModelAndView();
		List<QuestionInfo> exam=new ArrayList<QuestionInfo>();
		List<Integer> knowId=examService.getUserlearnedClass(userName);
		//handle里存放用户每章的掌握程度（小数）
		List<Integer> handle=examService.UserhandlePer(knowId);
		List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
		Map<String,Object> map=null;
		saveExamInfo.setExamName("智能组卷");
		saveExamInfo.setUserName(userName);
		saveExamInfo.setTypeId(1);
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
		JSONArray examjb=JSONArray.fromObject(maplist);
		mv.addObject("examInfo", examjb);
		mv.setViewName("exam");
		examlist.setExamlist(exam);
		return mv;
		//List<QuestionInfo> exam=examService.queryByChapterId(chapterId)
	}
	
	@RequestMapping(value="/checkAns")
	@ResponseBody
	public int checkAns(HttpServletRequest request,HttpServletResponse response,@RequestBody Ans[] ans)throws Exception{
		int len=ans.length;
		int score=0;
		List<Integer> rightId=new ArrayList<Integer>();
		List<QuestionInfo> exam=new ArrayList<QuestionInfo>();
		exam=examlist.getExamlist();
		List<Integer> questionAns=new ArrayList<Integer>();
		List<Integer> questionId=new ArrayList<Integer>();
		//JSONArray jsonArray = JSONArray.fromObject(json);  
		for(int i=0;i<len;i++){
			questionAns.add(ans[i].getAns());
			questionId.add(ans[i].getQuesId());
		}
		for(int k=0;k<exam.size();k++){
			if(!questionAns.get(k).equals(null)){
				if(questionAns.get(k)==exam.get(k).getAnswerId()){
					score++;
					rightId.add(questionId.get(k));
				}
			}
		}
		saveExamInfo.setScore(score);
		int result=examService.saveExam(saveExamInfo);
		System.out.println(result);
		ri.setRightId(rightId);
		return score;
	}
	
	@RequestMapping(value="/ansAnalysis")
	@ResponseBody
	public ModelAndView ansAnalysis(){
		ModelAndView mv=new ModelAndView();
		List<Integer> rightId=ri.getRightId();
		List<QuestionInfo> exam=examlist.getExamlist();
		
		List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
		Map<String,Object> map=null;
	
		for(int i=0;i<exam.size();i++){
			map=new LinkedHashMap<String,Object>();
			if(rightId.contains(exam.get(i).getQuestionId())){
				map.put("ansJudge", true);
			}
			else{
				map.put("ansJudge",false);
			}
			map.put("ansContent",exam.get(i).getAnswerContent());
			int ansId=exam.get(i).getAnswerId();
			String ansStr = null;
			if(ansId==1){
				ansStr="A";
			}
			else if(ansId==2){
				ansStr="B";
			}
			else if(ansId==3){
				ansStr="C";
			}
			else if(ansId==4){
				ansStr="D";
			}
			map.put("ans", ansStr);
			maplist.add(map);
		}
		JSONArray obj=JSONArray.fromObject(maplist);
		//obj.put("ansContent", ansContent);
		//obj.put("ans", ans);
		//obj.put("rightId", rightId);
		mv.addObject("ansInfo",obj);
		mv.setViewName("analysisPage");
		return mv;
	}
	
	@RequestMapping(value="/getExamHistory")
	@ResponseBody
	public ModelAndView getExamHistory(String userName){
		ModelAndView mv=new ModelAndView();
		List<Exam> examHistorys=examService.getExamHitstory(userName);
		List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
		Map<String,Object> map=null;
		if(examHistorys.size()>0){
			for(int i=0;i<examHistorys.size();i++){
				map=new LinkedHashMap<String,Object>();
				map.put("ExamId", examHistorys.get(i).getExamId());
				map.put("ExamName", examHistorys.get(i).getExamName());
				map.put("score", examHistorys.get(i).getScore());
				//map.put("TypeId", examHistorys.get(i).getTypeId());
				map.put("CreateTime", examHistorys.get(i).getCreateTime());
				maplist.add(map);
			}
			JSONArray obj=JSONArray.fromObject(maplist);
			mv.addObject("ExamHistorys",obj);
		}
		else{
			mv.addObject("ExamHistorys",0);
		}
		mv.setViewName("examHistorys");
		return mv;
	}
	
	@RequestMapping(value="/examDetails")
	@ResponseBody
	public ModelAndView examDetails(HttpServletRequest request,int examId){
		ModelAndView mv=new ModelAndView();
		
		return mv;
	}
}
