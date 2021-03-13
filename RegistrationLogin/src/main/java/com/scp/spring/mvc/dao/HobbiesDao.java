package com.scp.spring.mvc.dao;

import java.util.List;

import com.scp.spring.mvc.entities.HobbiesEntity;


public interface HobbiesDao {
	public boolean insertHobby(HobbiesEntity hobby);
	public HobbiesEntity fetchHobby(int hobbyId);
	public List<HobbiesEntity> removeHobby(int hobbyId);
	public HobbiesEntity modifyHobby(HobbiesEntity hobby);
	public List<HobbiesEntity> fetchAllHobby();
}
