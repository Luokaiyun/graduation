package com.stusystem.lky.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stusystem.lky.dao.UserInfoDAO;
import com.stusystem.lky.dto.UserLoginExceution;
import com.stusystem.lky.entity.UserInfo;
import com.stusystem.lky.exception.NoUserException;
import com.stusystem.lky.exception.UserLoginException;
import com.stusystem.lky.exception.WrongPasswordException;
import com.stusystem.lky.service.UserService;
import com.stusystem.lky.enums.LoginStateEnum;

@Service
public class UserServiceImpl implements UserService {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	//注入service依赖
	@Autowired
	private UserInfoDAO userInfoDao;
	
	public UserInfo getByUserName(String userName) {
		// TODO Auto-generated method stub
		return userInfoDao.queryByName(userName);
	}
	
	
	@Transactional
	public UserLoginExceution userLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		try{
			UserInfo userInfo=getByUserName(userName);
			if(userInfo==null||userInfo.equals("")){
				throw new NoUserException("NO_USER");
			}
			else{
				if(!userInfo.getUserPassword().equals(userPassword)){
					throw new WrongPasswordException("WRONG_PASSWORD");
				}
				else{
					return new UserLoginExceution(userInfo.getUserId(),LoginStateEnum.SUCESS,userInfo);
				}
			}
		}
		catch(NoUserException e1){
			throw e1;
		}
		catch(WrongPasswordException e2){
			throw e2;
		}
		catch(Exception e){
			logger.error(e.getMessage(),e);
			throw new UserLoginException("LOGIN_ERROR:"+e.getMessage());
		}
	}
	
	public int insertUser(String userName,String password){
		return userInfoDao.insertUser(userName, password);
	}
	
}
