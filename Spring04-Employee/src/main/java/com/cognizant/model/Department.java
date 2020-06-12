package com.cognizant.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.lang.NonNull;

public class Department {

	@NonNull
	@NumberFormat
	private int id;
	
	@NonNull
	@NotBlank
	@Size(min=1,max=30)
	private String name;

	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
