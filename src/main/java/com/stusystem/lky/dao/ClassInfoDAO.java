package com.stusystem.lky.dao;

import java.util.List;

import com.stusystem.lky.entity.ClassInfo;

public interface ClassInfoDAO {
	
	List<ClassInfo> queryByChapter(int chapterId);
	
	List<ClassInfo> allInfo();
}
