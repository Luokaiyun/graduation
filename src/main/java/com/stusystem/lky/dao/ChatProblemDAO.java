package com.stusystem.lky.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stusystem.lky.entity.ChatProblem;

public interface ChatProblemDAO {
	/**
	 * 返回所有问题信息
	 * @return
	 */
	List<ChatProblem> allProblem();
	
	/**
	 * 根据id查找问题
	 */
	ChatProblem problem(int problemId);
	/**
	 * 存储问题
	 */
	int insertProblem(@Param("problemContent")String problemContent,@Param("author")String author);
}
