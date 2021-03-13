package com.scp.spring.mvc.beans;

public class HobbiesBean {
	private int hobbyId;
	private String hobbyName;
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
	@Override
	public String toString() {
		return "HobbiesBean [hobbyId=" + hobbyId + ", hobbyName=" + hobbyName
				+ "]";
	}
	public HobbiesBean(int hobbyId, String hobbyName) {
		super();
		this.hobbyId = hobbyId;
		this.hobbyName = hobbyName;
	}
	public HobbiesBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
