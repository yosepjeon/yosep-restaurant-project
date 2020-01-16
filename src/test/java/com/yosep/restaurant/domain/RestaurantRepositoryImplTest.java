package com.yosep.restaurant.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RestaurantRepositoryImplTest {

	@Test
	public void save() {
		RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();
		
		int oldCount = restaurantRepository.findAll().size();
		
		Restaurant restaurant = new Restaurant("BeRyong", "Seoul");
		restaurantRepository.save(restaurant);
		
		assertThat(restaurant.getId(), is(1234L));
		
		int newCount = restaurantRepository.findAll().size();
		
		assertThat(newCount - oldCount, is(1));
	}

}
