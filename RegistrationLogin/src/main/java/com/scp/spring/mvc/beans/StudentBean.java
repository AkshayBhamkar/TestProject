package com.scp.spring.mvc.beans;

import java.util.List;



import org.springframework.web.multipart.MultipartFile;

public class StudentBean {
	private int studId;
	private String studName;
	private String studAge;
	private String gender;
	private String email;
	private String address;
	private int contactNo;
	
	private MultipartFile studentPhoto;
	
	private List<String> listOfHobbies;
	
	private String deptName;
	
	private List<String> listOfSubjs;
	private String filePath;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public MultipartFile getStudentPhoto() {
		return studentPhoto;
	}
	public void setStudentPhoto(MultipartFile studentPhoto) {
		this.studentPhoto = studentPhoto;
	}
	public List<String> getListOfHobbies() {
		return listOfHobbies;
	}
	public void setListOfHobbies(List<String> listOfHobbies) {
		this.listOfHobbies = listOfHobbies;
	}
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<String> getListOfSubjs() {
		return listOfSubjs;
	}
	public void setListOfSubjs(List<String> listOfSubjs) {
		this.listOfSubjs = listOfSubjs;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudAge() {
		return studAge;
	}
	public void setStudAge(String studAge) {
		this.studAge = studAge;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	

	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StudentBean [studId=" + studId + ", studName=" + studName
				+ ", studAge=" + studAge + ", gender=" + gender + ", email="
				+ email + ", address=" + address + ", contactNo=" + contactNo
				+ ", studentPhoto=" + studentPhoto + ", listOfHobbies="
				+ listOfHobbies + ", deptName=" + deptName + ", listOfSubjs="
				+ listOfSubjs + ", filePath=" + filePath + "]";
	}
	public StudentBean(int studId, String studName, String studAge,
			String gender, String email, String address, int contactNo,
			MultipartFile studentPhoto, List<String> listOfHobbies,
			String deptName, List<String> listOfSubjs, String filePath) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAge = studAge;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.contactNo = contactNo;
		this.studentPhoto = studentPhoto;
		this.listOfHobbies = listOfHobbies;
		this.deptName = deptName;
		this.listOfSubjs = listOfSubjs;
		this.filePath = filePath;
	}

	
	

	
}
