package com.yosep.restaurant.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RestaurantTests {

	@Test
	public void creation() {
//		Restaurant restaurant = new Restaurant(1004L,"Mcdonald","Seoul");
		Restaurant restaurant = Restaurant.builder()
				.id(1004L)
				.name("Bob zip")
				.address("Seoul")
				.build();
		
		assertThat(restaurant.getId(), is(1004L));
		assertThat(restaurant.getName(), is("Bob zip"));
		assertThat(restaurant.getAddress(), is("Seoul"));
	}

	@Test
	public void information() {
//		Restaurant restaurant = new Restaurant("Mcdonald", "Seoul");
		Restaurant restaurant = Restaurant.builder()
				.id(1004L)
				.name("Bob zip")
				.address("Seoul")
				.build();
		
		assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
	}
}
