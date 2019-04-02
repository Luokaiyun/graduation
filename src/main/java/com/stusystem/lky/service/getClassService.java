package com.stusystem.lky.service;

import java.util.List;

import com.stusystem.lky.entity.ClassInfo;

public interface getClassService {
	
	List<ClassInfo> getBychapterId(int chapterId);
	
	int insertUserClass(int classId,int userId);
}
