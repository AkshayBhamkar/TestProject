package com.scp.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.scp.spring.mvc.beans.DeptBean;
import com.scp.spring.mvc.service.DeptService;

/**
 * http://localhost:8091/dept/
 * 	/home  -- GET  -- listDepts()
 * 	/save --POST -- addDept
 *   /remove/{id} --GET -- removeDept()
 *   /edit/{id} --GET -- editDept()
 *   
 * 
 * @author Yogesh
 *
 */

@Controller
@RequestMapping(value="/dept")
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	static{
		System.out.println("inside Dept controller...!");
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String listDepts(Model model) {
		model.addAttribute("deptbean", new DeptBean());
		model.addAttribute("listDepts", this.deptService.getAllDepts());
		return "department";
	}
	
	//For add and update person both
	@RequestMapping(value= "/addDept", method = RequestMethod.POST)
	public String addDept(@ModelAttribute("deptbean") DeptBean deptBean)
	{
		
		System.out.println(deptBean);
		if(deptBean.getDeptId() == 0){
			this.deptService.addDept(deptBean);
		}else{
			this.deptService.updateDept(deptBean);
		}
		return "redirect:/dept/home";  
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeDept(@PathVariable("id") int id){
        this.deptService.deleteDept(id);
        return "redirect:/dept/home";
    }
 
    @RequestMapping("/edit/{id}")
    public ModelAndView editDept(@PathVariable("id") int id, Model model){
        model.addAttribute("deptbean", this.deptService.getDept(id));
        model.addAttribute("listDepts", this.deptService.getAllDepts());
        return new ModelAndView("department");
    }

}


