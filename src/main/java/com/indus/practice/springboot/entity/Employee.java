package com.indus.practice.springboot.entity;

import java.util.Date;
import java.util.Objects;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * employee_id int UN AI PK 
first_name varchar(20) 
last_name varchar(25) 
email varchar(25) 
phone_number varchar(20) 
hire_date date 
job_id varchar(10) 
salary decimal(8,2) 
commission_pct decimal(2,2) 
manager_id int UN 
department_id int UN
 */

@Component
@Scope("prototype")
@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private Double salary;
	private Double commissionPct;
	private Integer managerID;
	private Integer departmentID;
	
	public Employee() {}

	public Employee(Integer employeeId, String firstName, String lastName, String email, String phoneNumber,
			Date hireDate, String jobId, Double salary, Double commissionPct, Integer managerID, Integer departmentID) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerID = managerID;
		this.departmentID = departmentID;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date date) {
		this.hireDate = date;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Integer getManagerID() {
		return managerID;
	}

	public void setManagerID(Integer managerID) {
		this.managerID = managerID;
	}

	public Integer getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employeeId == other.employeeId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary="
				+ salary + ", commissionPct=" + commissionPct + ", managerID=" + managerID + ", departmentID="
				+ departmentID + "]";
	}
}
