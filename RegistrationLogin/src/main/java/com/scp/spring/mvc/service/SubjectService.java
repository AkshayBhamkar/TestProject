package com.scp.spring.mvc.service;

import java.util.List;

import com.scp.spring.mvc.beans.SubjectBean;

public interface SubjectService {
		public boolean addSubject(SubjectBean subj);
		public SubjectBean getSubject(int subj);
		public List<SubjectBean> deleteSubject(int subj);
		public SubjectBean updateSubject(SubjectBean subj);
		public List<SubjectBean> getAllSubjects();
}
