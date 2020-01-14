package com.yosep.restaurant.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private Long id;
	private String name;
	private String address;
	private List<MenuItem> menuItems = new ArrayList<>();
	
	public Restaurant(String name) {
		this.name = name;
	}
	
	public Restaurant(String name, String address) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.address = address;
	}
	
	public Restaurant(Long id,String name, String address) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.address = address;
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}

	public String getInformation() {
		// TODO Auto-generated method stub
		return name + " in " + address;
	}
	
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void addMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		menuItems.add(menuItem);
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		// TODO Auto-generated method stub
		for(MenuItem menuItem : menuItems) {
			addMenuItem(menuItem);
		}
	}
}
