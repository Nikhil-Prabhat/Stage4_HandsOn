package com.cognizant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;

@RestController
public class EmployeeController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		LOGGER.info("Start:Controller getAllEmployess");
		List<Employee> allEmployees = employeeService.getAllEmployees();
		LOGGER.info("End:Controller getAllEmployess");
		return allEmployees;
	}

}
