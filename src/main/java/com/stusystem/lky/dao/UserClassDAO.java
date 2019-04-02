package com.stusystem.lky.dao;

import java.util.List;

public interface UserClassDAO {
	
	int isnertuserClassState(int classId,int userId);
	
	List<Integer> getUserlearnedClass(int userId);
}
