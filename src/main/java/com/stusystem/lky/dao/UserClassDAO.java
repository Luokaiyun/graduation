package com.stusystem.lky.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stusystem.lky.entity.UserClass;

public interface UserClassDAO {
	
	int isnertuserClassState(@Param("knowId")int knowId,@Param("userId")int userId);
	
	List<UserClass> getUserlearnedClass(int userId);
}
