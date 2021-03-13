package com.scp.spring.mvc.service;

import java.util.List;

import com.scp.spring.mvc.beans.StudentBean;

public interface StudentService {
		public boolean addStudent(StudentBean stud);
		public StudentBean getStudent(int stud);
		public List<StudentBean> deleteStudent(int stud);
		public StudentBean updateStudent(StudentBean stud);
		public List<StudentBean> getAllStudents();
}
