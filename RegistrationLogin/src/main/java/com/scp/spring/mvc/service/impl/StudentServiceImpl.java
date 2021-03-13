package com.scp.spring.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scp.spring.mvc.beans.StudentBean;
import com.scp.spring.mvc.entities.DeptEntity;
import com.scp.spring.mvc.entities.StudentEntity;
import com.scp.spring.mvc.dao.DeptDao;
import com.scp.spring.mvc.dao.StudentDao;
import com.scp.spring.mvc.service.StudentService;

@Service("studService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studDao;
	
	@Autowired
	DeptDao deptDao;
	
	
	public DeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public StudentDao getStudDao() {
		return studDao;
	}

	public void setStudDao(StudentDao studDao) {
		this.studDao = studDao;
	}

	private StudentEntity convertToEntity(StudentBean bean){
		StudentEntity entity = new StudentEntity();
		entity.setStudName(bean.getStudName());
		entity.setAddress(bean.getAddress());
		entity.setContactNo(bean.getContactNo());
		entity.setDept(deptDao.fetchDeptByCode(bean.getDeptName()));
		entity.setGender(bean.getGender());
		entity.setEmail(bean.getEmail());
		entity.setStudAge(bean.getStudAge());
		entity.setStudId(bean.getStudId());
		entity.setStudentPhoto(bean.getFilePath());
		entity.setListOfHobbies(null); // write a method in hobbies which will fetch all based on given id
		entity.setListOfSubjs(null); // write a method in subjes which will fetch all based on given id
		return entity;
	}
	
	private StudentBean convertTobean(StudentEntity entity){
		StudentBean bean = new StudentBean();
		bean.setAddress(entity.getAddress());
		bean.setContactNo(entity.getContactNo());
		//bean.setDeptName(entity.getDept().getDeptCode());
		bean.setGender(entity.getGender());
		bean.setEmail(entity.getEmail());
		bean.setStudAge(entity.getStudAge());
		bean.setStudId(entity.getStudId());
		bean.setFilePath(entity.getStudentPhoto());
		bean.setListOfHobbies(null); // write a method in hobbies which will fetch all based on given id
		bean.setListOfSubjs(null); // write a method in subjes which will fetch all based on given id
		return bean;
	}
	

	private List<StudentBean> convertTobeans(List<StudentEntity> entities){
		List<StudentBean> beans = new ArrayList<StudentBean>();
		for(StudentEntity entity : entities){
			beans.add(convertTobean(entity));
		}
		return beans;
	}
	
	public boolean addStudent(StudentBean stud) {
		StudentEntity entity = convertToEntity(stud);
		entity.setStudId(ThreadLocalRandom.current().nextInt(1111,9999));
		return studDao.insertStudent(entity);
	}

	public StudentBean getStudent(int stud) {
		return convertTobean(studDao.fetchStudent(stud));
	}

	public List<StudentBean> deleteStudent(int stud) {
		return convertTobeans(studDao.removeStudent(stud));
	}

	public StudentBean updateStudent(StudentBean stud) {
		return convertTobean(studDao.modifyStudent(convertToEntity(stud)));
	}

	public List<StudentBean> getAllStudents() {
		return convertTobeans(studDao.fetchAllStudent());
	}
	
}
