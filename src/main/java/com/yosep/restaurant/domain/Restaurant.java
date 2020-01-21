package com.yosep.restaurant.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String address;
	
	@Transient
	private List<MenuItem> menuItems = new ArrayList<>();
	
	public Restaurant() {
		
	}
	
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
	
	public void setId(Long id) {
		this.id = id;
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
	
	public void updateInformation(String name, String address) {
		this.name = name;
		this.address = address;
	}
}
