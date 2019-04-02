package com.stusystem.lky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stusystem.lky.dao.ClassInfoDAO;
import com.stusystem.lky.dao.UserClassDAO;
import com.stusystem.lky.entity.ClassInfo;

@Service
public class getClassServiceImpl implements getClassService {
	@Autowired
	private ClassInfoDAO classInfoDAO;
	
	@Autowired
	private UserClassDAO userClassDAO;
	public List<ClassInfo> getBychapterId(int chapterId) {
		// TODO Auto-generated method stub
		return classInfoDAO.queryByChapter(chapterId);
	}
	public int insertUserClass(int classId,int userId){
		return userClassDAO.isnertuserClassState(classId, userId);
	}
}
