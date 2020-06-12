package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.exception.EmployeeNotFoundException;
import com.cognizant.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();

	}

	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		return employeeDao.updateEmployee(employee);
	}
	
	public void deleteEmployee(Employee employee) throws EmployeeNotFoundException
	{
		employeeDao.deleteEmployee(employee);
	}

}
