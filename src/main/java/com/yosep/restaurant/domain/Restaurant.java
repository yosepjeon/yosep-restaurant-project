package com.yosep.restaurant.domain;

public class Restaurant {
	private Long id;
	private String name;
	private String address;
	
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
}
