package com.stusystem.lky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stusystem.lky.dao.ChatAnsDAO;
import com.stusystem.lky.dao.ChatProblemDAO;
import com.stusystem.lky.entity.ChatAns;
import com.stusystem.lky.entity.ChatProblem;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	private ChatProblemDAO chatproDAO;
	
	@Autowired
	private ChatAnsDAO chatansDAO;
	
	public List<ChatProblem> getAll(){
		return chatproDAO.allProblem();
	}
	
	public List<ChatAns> getProAns(int problemId){
		return chatansDAO.allAns(problemId);
	}
	
	public int insertPro(String problemContent,String author){
		return chatproDAO.insertProblem(problemContent, author);
	}

	public int insertAns(int problemId,String ans,String author){
		return chatansDAO.insertAns(problemId, ans, author);
	}
}
