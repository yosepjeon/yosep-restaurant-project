package com.yosep.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MenuItem {
	@Id
	@GeneratedValue
	private Long id;
	
	private Long restaurantId;
	
	private String name;

	public MenuItem(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
