package com.cognizant;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.Controller.EmployeeController;
import com.cognizant.model.Department;
import com.cognizant.model.Employee;
import com.cognizant.model.Skill;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
class Spring04EmployeeApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private EmployeeController employeeController;

	@Test
	void contextLoads() {
		assertNotNull(employeeController);
	}

	@Test
	public void ExceptionCase() throws Exception {
		Employee e = new Employee();
		e.setDateOfBirth("09/09/1980");
		e.setDepartment(new Department(1, "3"));
		e.setSkill(new Skill(1, "2"));
		e.setId(3);
		e.setName("as");
		e.setPermanent("y");
		e.setSalary(400);

		ResultActions actions = mvc
				.perform(MockMvcRequestBuilders.put("/employees").content(asJsonString(e))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(status().reason("Employee Not Found"));

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
