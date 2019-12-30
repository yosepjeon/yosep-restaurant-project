package com.yosep.restaurant.domain;

public class Restaurant {
	private final String name;
	private String address;
	
	public Restaurant(String name) {
		this.name = name;
	}
	
	public Restaurant(String name, String address) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return "Mcdonald";
	}

	public String getInformation() {
		// TODO Auto-generated method stub
		return name + " in " + address;
	}
}
