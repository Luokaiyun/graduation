package com.stusystem.lky.service;

import java.util.List;

import com.stusystem.lky.entity.NoteInfo;

public interface NoteService {
	List<NoteInfo> getByUser(String userName);
	
	int insertNote(NoteInfo noteinfo);
}
