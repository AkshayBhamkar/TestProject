package com.scp.spring.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject_info")
public class SubjectEntity {
	@Id
	@Column(name="subj_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subjId;
	
	@Column(nullable=false,unique=true,name="subj_name")
	private String subjName;
	
	@Column(nullable=false,unique=true,name="subj_code",length=4)
	private String subjCode;
	
	@Column(nullable=false,name="prof_name")
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

	@Override
	public String toString() {
		return "SubjectEntity [subjId=" + subjId + ", subjName=" + subjName
				+ ", subjCode=" + subjCode + ", professor=" + professor + "]";
	}

	public SubjectEntity(int subjId, String subjName, String subjCode,
			String professor) {
		super();
		this.subjId = subjId;
		this.subjName = subjName;
		this.subjCode = subjCode;
		this.professor = professor;
	}

	public SubjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
