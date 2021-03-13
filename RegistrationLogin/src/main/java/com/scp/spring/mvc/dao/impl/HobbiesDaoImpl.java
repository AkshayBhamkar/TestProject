package com.scp.spring.mvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.scp.spring.mvc.entities.HobbiesEntity;
import com.scp.spring.mvc.dao.HobbiesDao;



@Repository("hobbyDao")
public class HobbiesDaoImpl implements HobbiesDao{

	
	public boolean insertHobby(HobbiesEntity hobby) {
		// TODO Auto-generated method stub
		return false;
	}


	public HobbiesEntity fetchHobby(int hobbyId) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<HobbiesEntity> removeHobby(int hobbyId) {
		// TODO Auto-generated method stub
		return null;
	}


	public HobbiesEntity modifyHobby(HobbiesEntity hobby) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<HobbiesEntity> fetchAllHobby() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

