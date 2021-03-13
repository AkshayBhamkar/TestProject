package com.scp.spring.mvc.beans;

public class DeptBean {
	private int deptId;
	private String deptName;
	private String deptCode;
	private String specialities;
	private int noOfLabs;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getSpecialities() {
		return specialities;
	}
	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}
	public int getNoOfLabs() {
		return noOfLabs;
	}
	public void setNoOfLabs(int noOfLabs) {
		this.noOfLabs = noOfLabs;
	}
	@Override
	public String toString() {
		return "DeptBean [deptId=" + deptId + ", deptName=" + deptName
				+ ", deptCode=" + deptCode + ", specialities=" + specialities
				+ ", noOfLabs=" + noOfLabs + "]";
	}
	public DeptBean(int deptId, String deptName, String deptCode,
			String specialities, int noOfLabs) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptCode = deptCode;
		this.specialities = specialities;
		this.noOfLabs = noOfLabs;
	}
	public DeptBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
