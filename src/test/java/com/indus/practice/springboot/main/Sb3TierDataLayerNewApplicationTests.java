package com.indus.practice.springboot.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import com.indus.practice.springboot.dao.EmployeeDao;
import com.indus.practice.springboot.entity.Employee;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = { "com.indus.practice.springboot.dao", "com.indus.practice.springboot.entity" })
class Sb3TierDataLayerNewApplicationTests {

	@Autowired
	private EmployeeDao daoObj;

//	@Test
//	void findEmployeeFromDb() {
//		//required input
//		int id = 100;
//		Employee actOut = daoObj.read(id);
//		assertThat(actOut).isNotNull();
//		assertThat(actOut.getFirstName()).isEqualTo("Steven");
//	}

	@Test
	void findTheEmployeeDetailsById() {
		// required input
		int id = 100;
		// expected output
		Employee expOut = new Employee();
		expOut.setEmployeeId(id);
		expOut.setFirstName("Steven");
		expOut.setLastName("King");
		// actual output

		Optional<Employee> actOut = daoObj.findById(id);
		// assert Equals
		assertTrue(actOut.isPresent(), "Employee not found");
		assertEquals(expOut.getFirstName(), actOut.get().getFirstName());

	}

	@Test
	void findAllTheEmployees() {
		Iterable<Employee> actOut = daoObj.findAll();

		assertNotNull(actOut, "The list of employees should not be null");
		List<Employee> employeeList = new ArrayList<>();
		actOut.forEach(employeeList::add);

		int expectedSize = 114;
		assertEquals(expectedSize, employeeList.size(), "the list of employees should contain the expected size");
	}

	@Test
	void saveTheDataToTheEmployees() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");

		Employee emp = new Employee();
		emp.setFirstName("Saroja");
		emp.setLastName("Kandula");
		emp.setEmail("SANGTSJ");
		emp.setPhoneNumber(null);
		try {
			emp.setHireDate(sdf.parse("2000-04-08"));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		emp.setJobId("ST_CLERK");
		emp.setSalary(25000.00);
		emp.setCommissionPct(null);
		emp.setManagerID(100);
		emp.setDepartmentID(null);

		// actual output
		Employee empObj = daoObj.save(emp);

		// Assertions
		assertNotNull(empObj, "Saved employee should not be null");
		assertNotNull(empObj.getEmployeeId(), "Saved employee should have an ID");
	}

}
