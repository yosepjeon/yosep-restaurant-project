package com.yosep.restaurant.domain;

import java.util.List;

public interface RestaurantRepository {
	public List<Restaurant> findAll();
	
	public Restaurant findById(Long id);

	public Restaurant save(Restaurant restaurant);
}
