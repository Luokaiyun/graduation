package com.stusystem.lky.service;

import java.util.List;

import com.stusystem.lky.entity.ChatAns;
import com.stusystem.lky.entity.ChatProblem;

public interface ChatService {
	public List<ChatProblem> getAll();
	public List<ChatAns> getProAns(int problemId);
	public int insertPro(String problemContent,String author);
	public int insertAns(int problemId,String ans,String author);
}
