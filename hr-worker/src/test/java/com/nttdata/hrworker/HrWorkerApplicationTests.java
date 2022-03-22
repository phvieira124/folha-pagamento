package com.nttdata.hrworker;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.CoreMatchers.is;

@SpringBootTest
@AutoConfigureMockMvc
class HrWorkerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void findOneStatus() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders
				.get("/workers/{id}", 1)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	void findOne() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders
				.get("/workers/{id}", 1)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name", is("Bob")));

		// .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(3)));

	}

	@Test
	void findAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/workers/all")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(3)));
	}

}
