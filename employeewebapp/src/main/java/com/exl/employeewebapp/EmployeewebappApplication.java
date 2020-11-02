package com.exl.employeewebapp;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.exl.employeewebapp.dao.EmployeeDAO;
import com.exl.employeewebapp.entity.Employee;


@SpringBootApplication//(exclude= {DataSourceAutoConfiguration.class})
@EnableJpaRepositories//(basePackages = "com.exl.employeewebapp.dao")
//@EntityScan("com.exl.employeewebapp.entity")
public class EmployeewebappApplication {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeewebappApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeewebappApplication.class, args);
	}
/*	
	@Bean
	public CommandLineRunner init(EmployeeDAO empRepository) {
		empRepository.deleteAll();
		return args -> {
			  empRepository.save(new Employee("Jack", "Bauer", "Manager", 23, LocalDate.now(), LocalDate.now().plusMonths(10)));
			  empRepository.save(new Employee("Chloe", "O'Brian", "QA",  24, LocalDate.now(), LocalDate.now().plusMonths(10)));
			  empRepository.save(new Employee("Kim", "Bauer", "BA", 45,  LocalDate.now(), LocalDate.now().plusMonths(10)));
			  empRepository.save(new Employee("David", "Palmer", "Manager",  36, LocalDate.now(), LocalDate.now().plusMonths(10)));
			  empRepository.save(new Employee("Michelle", "Dessler", "Developer",  30, LocalDate.now(), LocalDate.now().plusMonths(10)));
			  
			  empRepository.findAll().forEach(e -> System.out.println(e.getId() + " : " + e.fullName()));
			  
		};
	}
*/	
	public void removeEmployees(int begin, int end, EmployeeDAO repository) {
		for(int i = begin; i<=end; i++) {
			repository.deleteById((long) i);
		}
	}
	
}
