package com.yosep.restaurant.interfaces;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class) // Restaurant 컨트롤러를 테스트하겠다는 어노테이션
public class RestaurantControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void list() throws Exception {
		mvc.perform(get("/restaurants")).andExpect(status().isOk())
				.andExpect(content().string(containsString("\"id\":1004")))
				.andExpect(content().string(containsString("\"name\":\"Mcdonald\"")))
				.andExpect(content().string(containsString("\"address\":\"Seoul\"")));
	}
}
