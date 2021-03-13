package com.scp.spring.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scp.spring.mvc.entities.StudentEntity;
import com.scp.spring.mvc.dao.StudentDao;


@Repository("studDao")
public class StudentDaoImpl implements StudentDao{

	static{
		System.out.println("StudentDaoImpl Loaded.....!");
	}
	
	@Autowired
	SessionFactory sfactory;
	
	public SessionFactory getSfactory() {
		return sfactory;
	}

	public void setSfactory(SessionFactory sfactory) {
		this.sfactory = sfactory;
	}

	
	public boolean insertStudent(StudentEntity stud) {
		Session session = null;
		Transaction tr =null;
		try{
			session = sfactory.openSession();
			tr= session.beginTransaction();
			session.save(stud);
			return true;
		}catch(Exception e){
			System.out.println("Insert Student Failed..!"+e.getMessage());
			return false;
		}finally{
			closeResources(session, tr);
		}
		
	}

	
	public StudentEntity fetchStudent(int studId) {
		Session session = null;
		try{
			session = sfactory.openSession();
			return session.get(StudentEntity.class,studId);
		}catch(Exception e){
			System.out.println("fetch Student Failed..!"+e.getMessage());
			return null;
		}finally{
			closeResources(session, null);
		}
		
	}

	
	public List<StudentEntity> removeStudent(int studId) {
		Session session = null;
		Transaction tr =null;
		StudentEntity dbEntity = fetchStudent(studId);
		if (null!=dbEntity){
			try{
				session = sfactory.openSession();
				tr= session.beginTransaction();
				session.remove(dbEntity);
			}catch(Exception e){
				System.out.println("Fetch Student Failed..!"+e.getMessage());
			}finally{
				closeResources(session, tr);
			}
		}
		return fetchAllStudent();
	}

	
	public StudentEntity modifyStudent(StudentEntity stud) {
		Session session = null;
		Transaction tr =null;
		StudentEntity dbEntity = fetchStudent(stud.getStudId());
		if(dbEntity!=null){
			try{
				session = sfactory.openSession();
				tr= session.beginTransaction();
				return (StudentEntity) session.merge(stud);
			}catch(Exception e){
				System.out.println("MOdify Student Failed..!"+e.getMessage());
			}finally{
				closeResources(session, tr);
			}
		}
		return null;
	}



	public List<StudentEntity> fetchAllStudent() {
		Session session = null;
		try{
			session = sfactory.openSession();
			return session.createCriteria(StudentEntity.class).list();
		}catch(Exception e){
			System.out.println("Insert Student Failed..!"+e.getMessage());
			return null;
		}finally{
			closeResources(session, null);
		}
		
	}

	private void closeResources(Session session,Transaction tr){
		if(session!=null){
				if(tr!=null){
					session.flush();
					tr.commit();
				}
				session.close();
		}
	}
	
}

