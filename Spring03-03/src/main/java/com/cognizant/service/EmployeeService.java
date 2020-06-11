package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = employeeDao.getAllEmployees();
		return allEmployees;
	}

}
