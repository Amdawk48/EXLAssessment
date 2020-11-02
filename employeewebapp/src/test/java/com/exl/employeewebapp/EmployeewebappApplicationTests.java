package com.exl.employeewebapp;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityExistsException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exl.employeewebapp.entity.Employee;
import com.exl.employeewebapp.service.EmployeeService;

@SpringBootTest
class EmployeewebappApplicationTests {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	//@Test
	public void addEmployeeTest() {
		Employee testEmployee =
				new Employee("Jack", "Bauer", "Manager", 0, LocalDate.now(), LocalDate.now().plusMonths(10));
		assertThatExceptionOfType(EntityExistsException.class).isThrownBy( () -> {
			employeeService.addEmployee(testEmployee);
		});
	}
	
	@Test
	public void findExitingEmployeesInDatabaseTest() {
		List<Employee> employees = employeeService.list();
		assertTrue(!employees.isEmpty());
	}

}
