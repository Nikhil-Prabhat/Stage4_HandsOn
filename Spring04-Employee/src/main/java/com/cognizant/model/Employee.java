package com.cognizant.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {
	@NotNull
	@NumberFormat
	private int id;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 30)
	private String name;

	@NotNull
	@PositiveOrZero
	private long salary;

	@NotNull
	private String permanent;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String dateOfBirth;

	private Department department;

	private Skill skill;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(@NotNull @NumberFormat int id, @NotNull @NotBlank @Size(min = 1, max = 30) String name, @PositiveOrZero long salary,
			String permanent, String dateOfBirth, Department department, Skill skill) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
		this.skill = skill;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getPermanent() {
		return permanent;
	}

	public void setPermanent(String permanent) {
		this.permanent = permanent;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", department=" + department + ", skill=" + skill + "]";
	}

}
