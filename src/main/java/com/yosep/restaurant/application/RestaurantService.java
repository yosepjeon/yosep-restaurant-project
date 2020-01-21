package com.yosep.restaurant.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	// 실제로 update를 할때 save를 명시적으로 하지않고 Transactional 어노테이션을 이용해서
	// Transaction 범위를 잡아줌과 동시에 트랜잭션 범위에서 처리가 벗어났을때 같이 내용이 적용되는 것을 확인하였다.
	public Restaurant updateRestaurant(long id, String name, String address) {
		// TODO Auto-generated method stub
		Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
		
		restaurant.updateInformation(name, address);
		
		return restaurant;
	}
}
