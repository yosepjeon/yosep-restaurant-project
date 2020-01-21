package com.yosep.restaurant.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yosep.restaurant.domain.MenuItem;
import com.yosep.restaurant.domain.MenuItemRepository;
import com.yosep.restaurant.domain.Restaurant;
import com.yosep.restaurant.domain.RestaurantRepository;

// application layer을 추가하여 비지니스 로직을 구현
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
		//실제 실무에서는 이렇게 사용하면 안됨. restaurant에 대한 null exception이 안되어있기 때문.
		Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
		
		List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
		restaurant.setMenuItems(menuItems);
		
		return restaurant;
	}

	public List<Restaurant> getRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		// TODO Auto-generated method stub
		return restaurants ;
	}

	public Restaurant addRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return restaurantRepository.save(restaurant);
	}
}
