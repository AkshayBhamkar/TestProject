package com.scp.spring.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.scp.spring.mvc.beans.StudentBean;
import com.scp.spring.mvc.beans.SubjectBean;
import com.scp.spring.mvc.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	 String FILE_PATH="E:\\CLC\\1SpringDemo\\registrationLogin\\RegistrationLogin\\src\\main\\resources";
	@Autowired
	StudentService studService;

	static {
		System.out.println("inside Student controller...!");
	}

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String listStudents(Model model) {
		model.addAttribute("studbean", new StudentBean());
		model.addAttribute("studlist", this.studService.getAllStudents());
		model.addAttribute("subjects", this.getSubjectsList());
		model.addAttribute("depts", this.getDeptList());
		model.addAttribute("hobbies", this.getHobbies());
		return "student";
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("studbean") StudentBean studBean) throws IOException {
		MultipartFile multipartFile = studBean.getStudentPhoto();
		System.out.println(studBean);
		studBean.setFilePath(FILE_PATH+studBean.getStudId()+"_"+multipartFile.getOriginalFilename());
        FileCopyUtils.copy(multipartFile.getBytes(),new File(studBean.getFilePath()));
		if (studBean.getStudId() == 0) {
			this.studService.addStudent(studBean);
		} else {
			this.studService.updateStudent(studBean);
		}
		return "redirect:/student/home";
	}

	@RequestMapping(value="/remove/{id}")
	public String removeStudent(@PathVariable("id") int id) {
		this.studService.deleteStudent(id);
		return "redirect:/student/home";
	}

	@RequestMapping(value="/edit/{id}")
	public ModelAndView editStudent(@PathVariable("id") int id, Model model) {
		model.addAttribute("studbean", this.studService.getStudent(id));
		model.addAttribute("studlist", this.studService.getAllStudents());
		return new ModelAndView("student");
	}

	public List<SubjectBean> getSubjectsList()
	   {
	      List<SubjectBean> subjects = new ArrayList<SubjectBean>();
	      subjects.add(new SubjectBean(1,"Spring1","Sp1","AAA1"));
	      subjects.add(new SubjectBean(2,"Spring2","Sp2","AAA2"));
	      subjects.add(new SubjectBean(3,"Spring3","Sp3","AAA3"));
	      subjects.add(new SubjectBean(4,"Spring4","Sp4","AAA4"));
	      return  subjects;
	   }
	
	
		public Map<String,String> getDeptList(){
		   LinkedHashMap<String,String> depts = new LinkedHashMap<String,String>();
	      depts.put("IT","Information Technology");
	      depts.put("CSE","Computer Science");
	      depts.put("ENTC","Electronics");
	      depts.put("Infra", "Infrasturcture");
	      return  depts;
	   }
	
		public Map<String,String> getHobbies(){
			   LinkedHashMap<String,String> hobbies = new LinkedHashMap<String,String>();
			   hobbies.put("ch","Chess");
			   hobbies.put("sw","Swimming");
			   hobbies.put("WT","WatchingTv");
		      return  hobbies;
		   }
		
		
		
	
}


