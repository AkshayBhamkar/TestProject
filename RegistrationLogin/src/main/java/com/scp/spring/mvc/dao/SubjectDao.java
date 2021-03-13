package com.scp.spring.mvc.dao;

import java.util.List;

import com.scp.spring.mvc.entities.SubjectEntity;


public interface SubjectDao {
	public boolean insertSubj(SubjectEntity subj);
	public SubjectEntity fetchSubj(int subjId);
	public List<SubjectEntity> removeSubj(int subjId);
	public SubjectEntity modifySubj(SubjectEntity subj);
	public List<SubjectEntity> fetchAllSubj();
}
