package com.stusystem.lky.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stusystem.lky.entity.NoteInfo;

public interface NoteInfoDAO {
	/**插入note
	 * 
	 */
	int insertNote(NoteInfo noteinfo);
	/**根据author id查询note
	 * 
	 */
	List<NoteInfo> queryByUser(String userName);
}
