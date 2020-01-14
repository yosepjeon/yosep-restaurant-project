package com.yosep.restaurant.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yosep.restaurant.domain.MenuItem;
import com.yosep.restaurant.domain.MenuItemRepository;
import com.yosep.restaurant.domain.Restaurant;
import com.yosep.restaurant.domain.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
		// TODO Auto-generated constructor stub
		this.restaurantRepository = restaurantRepository;
		this.menuItemRepository = menuItemRepository;
	}
	
	public Restaurant getRestaurant(Long id) {
		Restaurant restaurant = restaurantRepository.findById(id);
		
		List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
		restaurant.setMenuItems(menuItems);
		
		return restaurant;
	}

	public List<Restaurant> getRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		// TODO Auto-generated method stub
		return restaurants ;
	}
}
