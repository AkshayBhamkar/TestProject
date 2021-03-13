package com.scp.spring.mvc.beans;

public class SubjectBean {
	private int subjId;
	private String subjName;
	private String subjCode;
	private String professor;
	public int getSubjId() {
		return subjId;
	}
	public void setSubjId(int subjId) {
		this.subjId = subjId;
	}
	public String getSubjName() {
		return subjName;
	}
	public void setSubjName(String subjName) {
		this.subjName = subjName;
	}
	public String getSubjCode() {
		return subjCode;
	}
	public void setSubjCode(String subjCode) {
		this.subjCode = subjCode;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public SubjectBean(int subjId, String subjName, String subjCode,
			String professor) {
		super();
		this.subjId = subjId;
		this.subjName = subjName;
		this.subjCode = subjCode;
		this.professor = professor;
	}
	public SubjectBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
