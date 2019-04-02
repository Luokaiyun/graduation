package com.stusystem.lky.entity;

public class ClassInfo {
	private int knowId;
	private int chapterId;
	private String className;
	private String classContent;
	public int getknowId() {
		return knowId;
	}
	public void setknowId(int knowId) {
		this.knowId = knowId;
	}
	public int getChapterId() {
		return chapterId;
	}
	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}
	public String getClassName() {
		//className=className.replace("\r", "");
		//className=className.replace("\t", "");
		//className=className.replace("\n", "");
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassContent() {
		//classContent=classContent.replace("\r", "");
		//classContent=classContent.replace("\t", "");
		//classContent=classContent.replace("\n", "");
		return classContent;
	}
	public void setClassContent(String classContent) {
		this.classContent = classContent;
	}
	
}
