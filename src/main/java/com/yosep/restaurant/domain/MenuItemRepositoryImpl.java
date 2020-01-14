package com.yosep.restaurant.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MenuItemRepositoryImpl implements MenuItemRepository{
	private List<MenuItem> menuItems = new ArrayList<>();
	
	public MenuItemRepositoryImpl() {
		menuItems.add(new MenuItem("BigMac"));
	}
	
	@Override
	public List<MenuItem> findAllByRestaurantId(Long id) {
		// TODO Auto-generated method stub
		return menuItems;
	}
	
}
