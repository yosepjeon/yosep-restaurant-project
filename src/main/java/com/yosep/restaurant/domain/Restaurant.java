package com.yosep.restaurant.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String name;
	@NotEmpty
	private String address;
	
	@Transient
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

	public String getInformation() {
		// TODO Auto-generated method stub
		return name + " in " + address;
	}

	public void addMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub		
		menuItems.add(menuItem);
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		// TODO Auto-generated method stub
		this.menuItems = new ArrayList<>(menuItems);
	}
	
	public void updateInformation(String name, String address) {
		this.name = name;
		this.address = address;
	}
}
