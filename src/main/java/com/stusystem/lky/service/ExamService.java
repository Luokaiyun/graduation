package com.stusystem.lky.service;

import java.util.List;

import com.stusystem.lky.entity.Exam;
import com.stusystem.lky.entity.QuestionInfo;

public interface ExamService {
	List<QuestionInfo> queryByChapterId(int chapterId);
	List<Integer> getUserlearnedClass(String userName);
	List<Integer> UserhandlePer(List<Integer> knowId);
	List<Exam> getExamHitstory(String userName);
	int saveExam(Exam exam);
}
