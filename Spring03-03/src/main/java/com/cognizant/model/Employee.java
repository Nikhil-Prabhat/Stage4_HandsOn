package com.cognizant.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Employee {
	private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);
	private String name;
	private String department;

	public Employee() {
		super();
		LOGGER.info("Inside the Employee Constructor");
	}

	public Employee(String name, String department) {
		super();
		this.name = name;
		this.department = department;
		
		LOGGER.info("Inside the Employee Constructor");
	}

	public String getName() {
		LOGGER.info("Inside the Employee Name Getter Method");
		return name;
	}

	public void setName(String name) {
		this.name = name;
		LOGGER.info("Inside the Employee Name Setter Method");
	}

	public String getDepartment() {
		LOGGER.info("Inside the Employee Department Getter Method");
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
		LOGGER.info("Inside the Employee Department Setter Method");
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + "]";
	}

}
