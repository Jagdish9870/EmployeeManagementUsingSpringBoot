package com.jack.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee,Integer> {

	

}
