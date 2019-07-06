package com.stusystem.lky.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stusystem.lky.entity.ChatAns;

public interface ChatAnsDAO {
	/**
	 * 根据问题id查找所有答案
	 */
	List<ChatAns> allAns(int problemId);
	/**
	 * 存储答案
	 */
	int insertAns(@Param("problemId")int problemId,@Param("ans")String ans,@Param("author")String author);
}
