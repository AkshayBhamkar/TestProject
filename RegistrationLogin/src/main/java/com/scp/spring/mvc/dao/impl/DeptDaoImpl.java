package com.scp.spring.mvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scp.spring.mvc.entities.DeptEntity;
import com.scp.spring.mvc.util.SessionFactoryUtil;
import com.scp.spring.mvc.dao.DeptDao;



@Repository("deptDao")
public class DeptDaoImpl implements DeptDao{
	static{
		System.out.println("DeptDaoImpl Loaded.....!");
	}
	
	@Autowired
	SessionFactory sfactory;
	
	public SessionFactory getSfactory() {
		return sfactory;
	}

	public void setSfactory(SessionFactory sfactory) {
		this.sfactory = sfactory;
	}

	
	
	public boolean insertDept(DeptEntity dept) {
		Session session = null;
		Transaction tr =null;
		try{
			session = sfactory.openSession();
			tr= session.beginTransaction();
			System.out.println("deptENtity" +dept);
			session.save(dept);
			return true;
		}catch(Exception e){
			System.out.println("Insert dept Failed..!"+e.getMessage());
			return false;
		}finally{
			SessionFactoryUtil.closeResources(session, tr);
		}
		
	}

	
	public DeptEntity fetchDept(int deptId) {
		Session session = null;
		try{
			session = sfactory.openSession();
			return session.get(DeptEntity.class,deptId);
		}catch(Exception e){
			System.out.println("fetch dept Failed..!"+e.getMessage());
			return null;
		}finally{
			SessionFactoryUtil.closeResources(session, null);
		}
		
	}

	
	public List<DeptEntity> removeDept(int deptId) {
		Session session = null;
		Transaction tr =null;
		DeptEntity dbEntity = fetchDept(deptId);
		if (null!=dbEntity){
			try{
				session = sfactory.openSession();
				tr= session.beginTransaction();
				session.remove(dbEntity);
			}catch(Exception e){
				System.out.println("Fetch dept Failed..!"+e.getMessage());
			}finally{
				SessionFactoryUtil.closeResources(session, tr);
			}
		}
		return fetchAllDept();
	}



	public DeptEntity modifyDept(DeptEntity dept) {
		Session session = null;
		Transaction tr =null;
		DeptEntity dbEntity = fetchDept(dept.getDeptId());
		if(dbEntity!=null){
			try{
				session = sfactory.openSession();
				tr= session.beginTransaction();
				dbEntity.setDeptCode(dept.getDeptCode());
				dbEntity.setDeptName(dept.getDeptName());
				dbEntity.setNoOfLabs(dept.getNoOfLabs());
				dbEntity.setSpecialities(dept.getSpecialities());
				return (DeptEntity) session.merge(dbEntity);
			}catch(Exception e){
				System.out.println("MOdify dept Failed..!"+e.getMessage());
			}finally{
				SessionFactoryUtil.closeResources(session, tr);
			}
		}
		return null;
	}



	public List<DeptEntity> fetchAllDept() {		
		Session session = null;
	try{
		session = sfactory.openSession();
		return session.createCriteria(DeptEntity.class).list();
	}catch(Exception e){
		System.out.println("fecth dept Failed..!"+e.getMessage());
		return null;
	}finally{
		SessionFactoryUtil.closeResources(session, null);
	}
}

	
	public DeptEntity fetchDeptByCode(String deptCode) {
		Session session = null;
	try{
		session = sfactory.openSession();
		Criteria cr = session.createCriteria(DeptEntity.class);
		cr.add(Restrictions.eq("deptCode", deptCode));
		List<DeptEntity> results = cr.list();
		return results.get(0); 
	}catch(Exception e){
		System.out.println("fecth dept Failed..!"+e.getMessage());
		return null;
	}finally{
		SessionFactoryUtil.closeResources(session, null);
	}

		
		
	}
	
}

