package com.jack.service;

import java.util.List;

import com.jack.entity.Employee;

public interface EmpService {
	public Employee saveEmp(Employee emp);
	public List<Employee> getAllEmp();
	public boolean deleteEmp(int id);
	public Employee getEmpById(int id);

}
