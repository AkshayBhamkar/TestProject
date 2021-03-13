package com.scp.spring.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scp.spring.mvc.beans.DeptBean;
import com.scp.spring.mvc.entities.DeptEntity;
import com.scp.spring.mvc.dao.DeptDao;
import com.scp.spring.mvc.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService{

	@Autowired
	DeptDao deptDao;
	
	public DeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	
	
	private DeptEntity convertDeptBeanToEntity(DeptBean bean){
		DeptEntity entity = new DeptEntity();
		entity.setDeptId(bean.getDeptId());
		entity.setDeptCode(bean.getDeptCode());
		entity.setDeptName(bean.getDeptName());
		entity.setNoOfLabs(bean.getNoOfLabs());
		entity.setSpecialities(bean.getSpecialities());
		return entity;
	}
	
	private DeptBean convertDeptEntityToBean(DeptEntity entity){
		DeptBean bean = new DeptBean();
		bean.setDeptId(entity.getDeptId());
		bean.setDeptCode(entity.getDeptCode());
		bean.setDeptName(entity.getDeptName());
		bean.setNoOfLabs(entity.getNoOfLabs());
		bean.setSpecialities(entity.getSpecialities());
		return bean;
	}
	

	private List<DeptBean> convertDeptEntitiesToBeans(List<DeptEntity> entities){
		List<DeptBean> beans = new ArrayList<DeptBean>();
		for (DeptEntity deptEntity : entities) {
				beans.add(convertDeptEntityToBean(deptEntity));
		}
		System.out.println(beans);
		return beans;
	}

	


	public boolean addDept(DeptBean dept) {
		DeptEntity entity = convertDeptBeanToEntity(dept);
		entity.setDeptId(ThreadLocalRandom.current().nextInt(111,999));
		return deptDao.insertDept(entity);
	}


	public DeptBean getDept(int dept) {
		return  convertDeptEntityToBean(deptDao.fetchDept(dept));
	}

	
	public List<DeptBean> deleteDept(int dept) {
		return convertDeptEntitiesToBeans(deptDao.removeDept(dept));
	}

	
	public DeptBean updateDept(DeptBean dept) {
		return convertDeptEntityToBean(deptDao.modifyDept(convertDeptBeanToEntity(dept)));
	}


	public List<DeptBean> getAllDepts() {
		return convertDeptEntitiesToBeans(deptDao.fetchAllDept());
	}
		
	
}