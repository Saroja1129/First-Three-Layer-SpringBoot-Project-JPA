package com.indus.practice.springboot.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.indus.practice.springboot.dao.EmployeeDao;
import com.indus.practice.springboot.entity.Employee;
import com.indus.practice.springboot.svc.IEmployeeService;

@SpringBootTest(classes = Sb3TierServiceLayerApplication.class)
class Sb3TierServiceLayerApplicationTests {
	
	@Autowired
	private IEmployeeService service;
	
	@MockBean
	private EmployeeDao repo;

	@Test
	void testFindEmployeeById() {
		
		//Mocking the Bean
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
		Employee emp = null;
		try {
			emp = new Employee(101,"Mahendra","Muttineni","SGDHYJU",null,sdf.parse("2000-04-08"),"ST-CLERK",null,2500.00,100,null);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		when(repo.findById(101)).thenReturn(Optional.of(emp));
		
		
		//Actual Output
		Optional<Employee> actOut = service.read(101);
		
		//Assertion
		assertTrue(actOut.isPresent(),"The Employee is not found");
		assertEquals("Mahendra", actOut.get().getFirstName());
	}

}
