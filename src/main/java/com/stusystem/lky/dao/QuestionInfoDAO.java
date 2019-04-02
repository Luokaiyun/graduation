package com.stusystem.lky.dao;

import java.util.List;

import com.stusystem.lky.entity.QuestionInfo;

public interface QuestionInfoDAO {
	List<QuestionInfo> queryByChapterId(int chapterId);

	
}
