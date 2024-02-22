package com.indus.practice.springboot.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indus.practice.springboot.entity.Employee;
import com.indus.practice.springboot.svc.IEmployeeService;

@RestController
public class EmployeeController {

	private final IEmployeeService service;
	
	public EmployeeController(IEmployeeService service) {
		this.service = service;
	}
	
	@GetMapping(name = "/read")
	public Optional<Employee> read(@RequestParam int id) {
		return service.read(id);
	}
	
}
