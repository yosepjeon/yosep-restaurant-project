package com.yosep.restaurant.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {

	List<MenuItem> findAllByRestaurantId(Long id);
	
	void deleteById(Long id); 
}
