package com.rudra.project_employee.EmployeeProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rudra.project_employee.EmployeeProject.entity.Employee;
import com.rudra.project_employee.EmployeeProject.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeProjectApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectApplication.class, args);
		
		System.out.println("Connected");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}",employeeRepository.findAll() );	
		logger.info("user id 1001 -> {}",employeeRepository.findById(1001L));
		logger.info("Inserting 1004 -> {} ", employeeRepository.insert(new Employee(1004L, "James", 50000, "Manager")));
		logger.info("Updating 1001 -> {} ", employeeRepository.insert(new Employee(1001L, "Tara", 20000, "Accountant")));
		employeeRepository.deleteById(1002L);
	}

}
