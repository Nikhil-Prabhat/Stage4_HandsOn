package com.cognizant.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.EmployeeNotFoundException;
import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;

@RestController
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("Start: UpdateEmployee");
		Employee emp = employeeService.updateEmployee(employee);
		LOGGER.info("End: UpdateEmployee");
		return emp;
	}
	
	@DeleteMapping("/employees")
	public void deleteEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("Start: DeleteEmployees");
		employeeService.deleteEmployee(employee);
		LOGGER.info("End: DeleteEmployees");		
		
	}

}
