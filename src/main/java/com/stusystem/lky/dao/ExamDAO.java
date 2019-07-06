package com.stusystem.lky.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stusystem.lky.entity.Exam;

public interface ExamDAO {
	int insertExam(@Param("examName")String examName,@Param("typeId")int typeId,@Param("userName")String userName,@Param("score")int score);
	
	List<Exam> allExam(String userName);
	
	Exam queryByExamId(int examId);
}
