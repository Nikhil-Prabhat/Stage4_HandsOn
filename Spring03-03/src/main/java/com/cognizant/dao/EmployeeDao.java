package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.model.Employee;

@Component
public class EmployeeDao {
	
	public static List<Employee> EMPLOYEE_LIST = new ArrayList<>();
	
	public EmployeeDao()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Employee.xml");
		EMPLOYEE_LIST = context.getBean("employeeList",ArrayList.class);
	}
	
	public List<Employee> getAllEmployees()
	{
		return EMPLOYEE_LIST;
	}
	

}
