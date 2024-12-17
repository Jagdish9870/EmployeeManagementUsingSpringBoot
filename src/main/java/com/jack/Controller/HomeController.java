package com.jack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jack.entity.Employee;
import com.jack.service.EmpService;


import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model; // Correct

@Controller
public class HomeController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/index")
	public String index(Model m ) {
		List<Employee> list=empService.getAllEmp();
		m.addAttribute("empList",list);
		
		
		return "index";
	}
	@GetMapping("/loadEmpSave")
	public String EmpSave() {
		
		return "emp_save";
	}
	
	@GetMapping("/editEmp/{id}")
	public String EditEmp(@PathVariable int id , Model m) {
		Employee emp=empService.getEmpById(id);
		m.addAttribute("emp",emp);
		
		return "emp_edit";
	}
	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee emp , HttpSession httpSession) {
		
		Employee saveNewEmp =empService.saveEmp(emp);
		
		if(saveNewEmp != null) {
			httpSession.setAttribute("msg","successfully added");
		}
		else {
			httpSession.setAttribute("msg","something wrong");
		}
		
		
//		System.out.print(emp);
		return "redirect:/loadEmpSave";
	}
	
	
	@PostMapping("/updateEmpDtlls")
	public String updateEmp(@ModelAttribute Employee emp , HttpSession httpSession) {
		
		Employee updateEmp =empService.saveEmp(emp);
		
		if(updateEmp != null) {
			httpSession.setAttribute("msg","successfully updated");
		}
		else {
			httpSession.setAttribute("msg","something wrong");
		}
		
		

		return "redirect:/index";
	}
	@GetMapping("/deleteEmpdtls/{id}")
	public String deleteEmpl(@PathVariable int id ,HttpSession httpSession) {
		boolean f=empService.deleteEmp(id);

		if(f) {
			httpSession.setAttribute("msg","deleted succesfully!");
		}
		else {
			httpSession.setAttribute("msg","something wrong");
		}
		
		return "redirect:/index";
	}
	

}
