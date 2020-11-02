package com.exl.employeewebapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exl.employeewebapp.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {
	
	
}
