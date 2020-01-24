package com.yosep.restaurant.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long>{
	Review save(Review review);
	
	List<Review> findAllByRestaurantId(Long restaurantId);
}
