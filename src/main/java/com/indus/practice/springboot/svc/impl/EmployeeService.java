package com.indus.practice.springboot.svc.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indus.practice.springboot.dao.EmployeeDao;
import com.indus.practice.springboot.entity.Employee;
import com.indus.practice.springboot.svc.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	private final EmployeeDao repo;

	@Autowired
	public EmployeeService(EmployeeDao repo) {
		this.repo = repo;
	}

	@Override
	public Employee create(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public Optional<Employee> read(int id) {
		return repo.findById(id);
	}

	@Override
	public Employee update(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public boolean delete(int id) {
		if (id != 0) {
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
