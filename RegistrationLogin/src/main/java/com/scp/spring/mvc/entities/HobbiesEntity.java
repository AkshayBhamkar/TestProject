package com.scp.spring.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hobbies_info")
public class HobbiesEntity {
	@Id
	@Column(name="hobby_id")
	private int hobbyId;
	
	@Column(nullable=false,unique=true,name="hobby_name")
	private String hobbyName;

	@Column(nullable=false,unique=true,name="hobby_code")
	private String hobbyCode;

	@Override
	public String toString() {
		return "HobbiesEntity [hobbyId=" + hobbyId + ", hobbyName=" + hobbyName
				+ ", hobbyCode=" + hobbyCode + "]";
	}
	
/*	@ManyToOne
    @JoinColumn(name="studId", nullable=false)
	private StudentEntity student;
*/
	public int getHobbyId() {
		return hobbyId;
	}

	public void setHobbyId(int hobbyId) {
		this.hobbyId = hobbyId;
	}

	public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}

	public String getHobbyCode() {
		return hobbyCode;
	}

	public void setHobbyCode(String hobbyCode) {
		this.hobbyCode = hobbyCode;
	}

	public HobbiesEntity(int hobbyId, String hobbyName, String hobbyCode) {
		super();
		this.hobbyId = hobbyId;
		this.hobbyName = hobbyName;
		this.hobbyCode = hobbyCode;
	}

	public HobbiesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
