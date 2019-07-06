package com.stusystem.lky.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stusystem.lky.dao.ClassInfoDAO;
import com.stusystem.lky.dao.ExamDAO;
import com.stusystem.lky.dao.QuestionInfoDAO;
import com.stusystem.lky.dao.UserClassDAO;
import com.stusystem.lky.dao.UserInfoDAO;
import com.stusystem.lky.entity.ClassInfo;
import com.stusystem.lky.entity.Exam;
import com.stusystem.lky.entity.QuestionInfo;
import com.stusystem.lky.entity.UserClass;

@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	private QuestionInfoDAO questionDao;
	
	@Autowired
	private UserClassDAO userclassDAO;
	
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Autowired
	private ClassInfoDAO classinfoDAO;
	
	@Autowired
	private ExamDAO examDAO;
	
	@Override
	public List<QuestionInfo> queryByChapterId(int chapterId) {
		// TODO Auto-generated method stub
		return questionDao.queryByChapterId(chapterId);
	}
	
	public List<Integer> getUserlearnedClass(String userName){
		 int userId=userInfoDAO.queryByName(userName).getUserId();
		 List<Integer> list=new ArrayList<Integer>();
		 List<UserClass> userclasslist=userclassDAO.getUserlearnedClass(userId);
		 for(int i=0;i<userclasslist.size();i++){
			 list.add(userclasslist.get(i).getKnowId());
		 }
		 return list;
	}
	
	public List<Integer> UserhandlePer(List<Integer> knowId){
		List<Integer> handle=new ArrayList<Integer>();
		//Map<String,Integer> map=new HashMap<String,Integer>();
		List<ClassInfo> allclass=classinfoDAO.allInfo();
		int len=knowId.size();
		int infolen=allclass.size();
		int chapterNum=4;
		int[] cArr=new int[chapterNum];
		int sum=0;
		for(int k=1;k<chapterNum;k++){
			cArr[k]=0;
		}
		for(int i=0;i<len;i++){
			int chaptertemp=0;
			for(int j=0;j<infolen;j++){
				int temp1=knowId.get(i);
				ClassInfo temp2=allclass.get(i);
				if(temp1==temp2.getknowId()){
					chaptertemp=temp2.getChapterId()-1;
					break;
				}
			}
			cArr[chaptertemp]++;
		}
		for(int l=0;l<cArr.length;l++){
			sum=sum+cArr[l];
		}
		for(int a=0;a<cArr.length;a++){
			cArr[a]=cArr[a]/sum;
		}
		for(int c=0;c<cArr.length;c++){
			handle.add(cArr[c]);
		}
		return handle;
	}
	
	public List<Exam> getExamHitstory(String userName){
		List<Exam> examlist=examDAO.allExam(userName);
		return examlist;
	}
	
	public int saveExam(Exam exam){
		return examDAO.insertExam(exam.getExamName(), exam.getTypeId(), exam.getUserName(), exam.getScore());
	}

}
