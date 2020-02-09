package com.yosep.restaurant.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class CategoryTests {

	@Test
	public void creation() {
		Category category = Category.builder().name("Korean Food").build();
		
		assertThat(category.getName(), is("Korean Food"));
	}

}
