package com.jack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jack.entity.Employee;
import com.jack.repository.EmpRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class EmpServiceImpl  implements EmpService{
	
	@Autowired
	private EmpRepo empRepo;

	@Override
	public Employee saveEmp(Employee emp) {
		
		Employee newEmp =empRepo.save(emp);
		return newEmp;
	}

	@Override
	public List<Employee> getAllEmp() {
		
		return empRepo.findAll();
	}

	@Override
	public boolean deleteEmp(int id) {

		Employee uniqueEmp =empRepo.findById(id).get();
		if(uniqueEmp !=null) {
			empRepo.delete(uniqueEmp);
			return true;
		}
		return false;
		
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();
	}
	
	// to print msg on webpage under add employee...
	
	public void removeSessionMessage() {
		HttpSession httpSession=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		httpSession.removeAttribute("msg");
	}
	
	

}
