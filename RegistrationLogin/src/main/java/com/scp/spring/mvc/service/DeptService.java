package com.scp.spring.mvc.service;

import java.util.List;

import com.scp.spring.mvc.beans.DeptBean;

public interface DeptService {

	public boolean addDept(DeptBean dept);
	public DeptBean getDept(int dept);
	public List<DeptBean> deleteDept(int dept);
	public DeptBean updateDept(DeptBean dept);
	public List<DeptBean> getAllDepts();


}
