package com.yosep.restaurant.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RestaurantTests {

	@Test
	public void creation() {
		Restaurant restaurant = new Restaurant("Mcdonald");
		assertThat(restaurant.getName(), is("Mcdonald"));
	}

	@Test
	public void information() {
		Restaurant restaurant = new Restaurant("Mcdonald", "Seoul");
		
		assertThat(restaurant.getInformation(), is("Mcdonald in Seoul"));
	}
}
