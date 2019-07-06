package com.stusystem.lky.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stusystem.lky.entity.QuestionInfo;

public interface ExamQuestionDAO {
	int insertExamQuestion(@Param("questionId")int questionId,@Param("examId")int examId);
	List<QuestionInfo> queryByExamId(int examId);
}
