package com.yosep.restaurant.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RestaurantTests {

	@Test
	public void creation() {
		Restaurant restaurant = new Restaurant(1004L,"Mcdonald","Seoul");
		assertThat(restaurant.getId(), is(1004L));
		assertThat(restaurant.getName(), is("Mcdonald"));
		assertThat(restaurant.getAddress(), is("Seoul"));
	}

	@Test
	public void information() {
		Restaurant restaurant = new Restaurant("Mcdonald", "Seoul");
		
		assertThat(restaurant.getInformation(), is("Mcdonald in Seoul"));
	}
}
