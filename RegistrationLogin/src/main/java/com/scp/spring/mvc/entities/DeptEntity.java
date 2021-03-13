package com.scp.spring.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dept_info")
public class DeptEntity {
	@Id
	@Column(name="dept_id")
	private int deptId;
	@Column(nullable=false,unique=true,name="dept_name")
	private String deptName;
	@Column(nullable=false,unique=true,name="dept_code",length=4)
	private String deptCode;
	private String specialities;
	private int noOfLabs;
	@Override
	public String toString() {
		return "DeptEntity [deptId=" + deptId + ", deptName=" + deptName
				+ ", deptCode=" + deptCode + ", specialities=" + specialities
				+ ", noOfLabs=" + noOfLabs + "]";
	}
	public DeptEntity(int deptId, String deptName, String deptCode,
			String specialities, int noOfLabs) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptCode = deptCode;
		this.specialities = specialities;
		this.noOfLabs = noOfLabs;
	}
	public DeptEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
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

	
	
}
