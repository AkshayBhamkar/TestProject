package com.scp.spring.mvc.dao;

import java.util.List;

import com.scp.spring.mvc.entities.DeptEntity;


public interface DeptDao {
	public boolean insertDept(DeptEntity dept);
	public DeptEntity fetchDept(int deptId);
	public List<DeptEntity> removeDept(int deptId);
	public DeptEntity modifyDept(DeptEntity dept);
	public List<DeptEntity> fetchAllDept();
	public DeptEntity fetchDeptByCode(String deptCode);
}
