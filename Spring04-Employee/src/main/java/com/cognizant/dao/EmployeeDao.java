package com.cognizant.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.exception.EmployeeNotFoundException;
import com.cognizant.model.Employee;

@Component
public class EmployeeDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
	public static List<Employee> EMPLOYEE_LIST = new ArrayList<>();

	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Employee.xml");
		EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
	}

	public List<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}

	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		Employee e = null;
		int flag = 0;
		for (Employee emp : EMPLOYEE_LIST) {
			if (emp.getId() == employee.getId()) {
				emp.setDateOfBirth(employee.getDateOfBirth());
				emp.setDepartment(employee.getDepartment());
				emp.setName(employee.getName());
				emp.setPermanent(employee.getPermanent());
				emp.setSalary(employee.getSalary());
				emp.setSkill(employee.getSkill());
				flag = 1;
				e=emp;
				break;

			}

		}

		if (flag == 0) {
			throw new EmployeeNotFoundException();
		}

		return e;
	}
	
	public void deleteEmployee(Employee employee) throws EmployeeNotFoundException
	{
		
		int flag=0;
		
		Iterator itr = EMPLOYEE_LIST.iterator();
		
		while(itr.hasNext())
		{
			Employee e = (Employee)itr.next();
			if(e.getId() == employee.getId())
			{
				itr.remove();
				LOGGER.info("Deletion Successful");
				flag=1;
				break;
			}
		}
		
		if(flag == 0)
		{
			throw new EmployeeNotFoundException();
		}
	
	}

}
