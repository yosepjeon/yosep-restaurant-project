package com.yosep.restaurant.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository{
	// 현재는 리스트를 이용해서 기능을 구현했지만 데이터베이스를 활용하여 효과적으로 관리할 것.
	// 추가 구현 예정...
	private List<Restaurant> restaurants = new ArrayList<>();

	public RestaurantRepositoryImpl() {
		restaurants.add(new Restaurant(1004L, "Mcdonald", "Seoul"));
		restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
	}

	public List<Restaurant> findAll() {
		return restaurants;
	}

	public Restaurant findById(Long id) {
		return restaurants.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public Restaurant save(Restaurant restaurant) {
		// TODO Auto-generated method stub
		restaurant.setId(1234L);
		restaurants.add(restaurant);
		
		return restaurant;
	}
}
