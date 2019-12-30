package com.yosep.restaurant.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yosep.restaurant.domain.Restaurant;

@RestController
public class RestaurantController {
	
	@GetMapping("/restaurants")
	public List<Restaurant> list() {
		List<Restaurant> restaurants = new ArrayList<>();
		restaurants.add(new Restaurant(1004L,"Mcdonald","Seoul"));
		return restaurants;
	}
}
