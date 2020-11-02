package com.exl.employeewebapp.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exl.employeewebapp.dao.EmployeeDAO;
import com.exl.employeewebapp.entity.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


//@Service
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeService {
    
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EmployeeDAO employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> list(){
		return employeeRepository.findAll();
	}
	
	public void removeEmployee() {
		
	}
	
	//@Transactional
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee employee) {
		//this.entityManager.persist(employee);
		this.employeeRepository.save(employee);
	}
	
	public Optional<Employee> findEmployeeById(long id) {	
		return employeeRepository.findById(id);
	}
}
