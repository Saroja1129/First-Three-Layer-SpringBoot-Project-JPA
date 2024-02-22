package com.indus.practice.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indus.practice.springboot.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{


//	Employee read(int id);
}
