package com.indus.practice.springboot.svc;

import java.util.Optional;

import com.indus.practice.springboot.entity.Employee;

public interface IEmployeeService {

	Employee create(Employee emp);
	
	Optional<Employee> read(int id);
	
	Employee update(Employee emp);
	
	boolean delete(int id);
}
