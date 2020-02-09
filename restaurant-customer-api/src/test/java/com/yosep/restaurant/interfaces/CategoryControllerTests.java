package com.yosep.restaurant.interfaces;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.yosep.restaurant.application.CategoryService;
import com.yosep.restaurant.domain.Category;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTests {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CategoryService CategoryService;
	
	@Test
	public void list() throws Exception {
		List<Category> categories = new ArrayList<>();
		categories.add(Category.builder().name("Korean Food").build());
		
		given(CategoryService.getCategories()).willReturn(categories);
		
		mvc.perform(get("/categories"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Korean Food")));
	}
}