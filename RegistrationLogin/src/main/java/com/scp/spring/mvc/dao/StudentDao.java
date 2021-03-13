package com.scp.spring.mvc.dao;

import java.util.List;

import com.scp.spring.mvc.entities.StudentEntity;

public interface StudentDao {
	public boolean insertStudent(StudentEntity stud);
	public StudentEntity fetchStudent(int studId);
	public List<StudentEntity> removeStudent(int studId);
	public StudentEntity modifyStudent(StudentEntity stud);
	public List<StudentEntity> fetchAllStudent();
}
