package com.springboot.hospitaldetails;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class PatientTest extends HospitaldetailsApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testDoctor() throws Exception {
		mockMvc.perform(get("/patient")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("kumar")).andExpect(jsonPath("$.age").value("25"))
				.andExpect(jsonPath("$.gender").value("male")).andExpect(jsonPath("$.doctor_name").value("baburao"))
				.andExpect(jsonPath("$.date_of_visit").value("12-08-2022"))
				.andExpect(jsonPath("$.prescription").value("fever"));;

	}

}