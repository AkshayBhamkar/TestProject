package com.scp.spring.mvc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="stud_info")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stud_id")
	private int studId;
	@Column(nullable=false,name="stud_name")
	private String studName;
	@Column(nullable=false,name="stud_age")
	private String studAge;
	@Column(nullable=false,name="stud_gender",length=1)
	private String gender;
	@Column(nullable=false,name="stud_address")
	private String address;
	
	@Column(nullable=false,unique=true,name="stud_email")
	private String email;
	@Column(nullable=false,unique=true,name="stud_contact")
	private int contactNo;
	

	@Column(nullable=false,unique=true,name="stud_pic")
	private String studentPhoto;
	
	@OneToMany
	private List<HobbiesEntity> listOfHobbies;
	
	@OneToOne(cascade=CascadeType.ALL)
	private DeptEntity dept;
	
	@ManyToMany
	private List<SubjectEntity> listOfSubjs;
	
	
	public DeptEntity getDept() {
		return dept;
	}
	public void setDept(DeptEntity dept) {
		this.dept = dept;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "StudentEntity [studId=" + studId + ", studName=" + studName
				+ ", studAge=" + studAge + ", gender=" + gender + ", address="
				+ address + ", email=" + email + ", contactNo=" + contactNo
				+ ", studentPhoto=" + studentPhoto + ", listOfHobbies="
				+ listOfHobbies + ", deptName=" + dept + ", listOfSubjs="
				+ listOfSubjs + "]";
	}
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStudentPhoto() {
		return studentPhoto;
	}
	public void setStudentPhoto(String studentPhoto) {
		this.studentPhoto = studentPhoto;
	}
	public List<HobbiesEntity> getListOfHobbies() {
		return listOfHobbies;
	}
	public void setListOfHobbies(List<HobbiesEntity> listOfHobbies) {
		this.listOfHobbies = listOfHobbies;
	}
	public List<SubjectEntity> getListOfSubjs() {
		return listOfSubjs;
	}
	public void setListOfSubjs(List<SubjectEntity> listOfSubjs) {
		this.listOfSubjs = listOfSubjs;
	}
	public StudentEntity(int studId, String studName, String studAge,
			String gender, String address, String email, int contactNo,
			String studentPhoto, List<HobbiesEntity> listOfHobbies,
			DeptEntity deptName, List<SubjectEntity> listOfSubjs) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAge = studAge;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
		this.studentPhoto = studentPhoto;
		this.listOfHobbies = listOfHobbies;
		this.dept = deptName;
		this.listOfSubjs = listOfSubjs;
	}

	
	

	


}
