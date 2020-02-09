package com.yosep.restaurant.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{
	public List<Restaurant> findAll();
	
	public Optional<Restaurant> findById(Long id);

	public Restaurant save(Restaurant restaurant);
}
