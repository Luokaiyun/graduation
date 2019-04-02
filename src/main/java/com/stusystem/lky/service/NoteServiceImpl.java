package com.stusystem.lky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stusystem.lky.dao.NoteInfoDAO;
import com.stusystem.lky.entity.NoteInfo;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteInfoDAO noteinfoDao;
	
	public List<NoteInfo> getByUser(String userName){
		return noteinfoDao.queryByUser(userName);
	}
	
	public int insertNote(NoteInfo noteinfo){
		return noteinfoDao.insertNote(noteinfo);
	}

}
