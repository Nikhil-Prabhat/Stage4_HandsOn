package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.model.Employee;

@Component
public class DepartmentDao {
	
	public static List<String> DEPARTMENTS= new ArrayList<>();
	
	public DepartmentDao()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Employee.xml");
		ArrayList<Employee> employeeList = context.getBean("employeeList",ArrayList.class);
		
		for(Employee emp:employeeList)
		{
			DEPARTMENTS.add(emp.getDepartment());
		}
	}
	
	public List<String> getAllDepartments()
	{
		return DEPARTMENTS;
	}

}
