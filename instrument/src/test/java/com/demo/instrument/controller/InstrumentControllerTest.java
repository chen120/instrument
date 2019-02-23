package com.demo.instrument.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InstrumentControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void addSuccessfully() throws Exception {
		String param = "?publisher=LME&code=PB_03_2018&lastTradingDate=15-03-2018&deliveryDate=17-03-2018&"
				+ "market=LME_PB&label=Lead 13 March 2018";
		this.mockMvc.perform(post("/instrument/add"+param)).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("success")));
	}

}
