package com.yosep.restaurant.domain;

import java.util.List;

public interface MenuItemRepository {

	public List<MenuItem> findAllByRestaurantId(Long id);
	
}
