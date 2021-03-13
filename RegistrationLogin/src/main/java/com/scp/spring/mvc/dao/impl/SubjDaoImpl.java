package com.scp.spring.mvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.scp.spring.mvc.entities.SubjectEntity;
import com.scp.spring.mvc.dao.SubjectDao;



@Repository("subjDao")
public class SubjDaoImpl implements SubjectDao{

	
	public boolean insertSubj(SubjectEntity subj) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public SubjectEntity fetchSubj(int subjId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<SubjectEntity> removeSubj(int subjId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public SubjectEntity modifySubj(SubjectEntity subj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<SubjectEntity> fetchAllSubj() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

