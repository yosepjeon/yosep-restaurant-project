package com.yosep.restaurant.domain;

public class RestaurantNotFoundException extends RuntimeException{

	public RestaurantNotFoundException(long id) {
		// TODO Auto-generated constructor stub
		super("Could not find retaurant " + id);
	}
	
}
