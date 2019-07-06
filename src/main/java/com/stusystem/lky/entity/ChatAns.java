package com.stusystem.lky.entity;

public class ChatAns {
	private int id;
	private int problemId;
	private String problemAns;
	private String ansAuthor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProblemId() {
		return problemId;
	}
	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	public String getProblemAns() {
		return problemAns;
	}
	public void setProblemAns(String problemAns) {
		this.problemAns = problemAns;
	}
	public String getAnsAuthor() {
		return ansAuthor;
	}
	public void setAnsAuthor(String ansAuthor) {
		this.ansAuthor = ansAuthor;
	}

}
