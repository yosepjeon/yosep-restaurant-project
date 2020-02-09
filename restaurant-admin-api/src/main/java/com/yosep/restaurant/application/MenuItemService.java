package com.yosep.restaurant.application;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yosep.restaurant.domain.MenuItem;
import com.yosep.restaurant.domain.MenuItemRepository;

@Service
@Transactional
public class MenuItemService {

	private MenuItemRepository menuItemRepository;

	@Autowired
	public MenuItemService(MenuItemRepository menuItemRepository) {
		this.menuItemRepository = menuItemRepository;
	}
	
	public List<MenuItem> getMenuItems(long id) {
		List<MenuItem> menuItems = new ArrayList<>();
//		menuItems.add(MenuItem.builder().name("Kimchi").build());
		
		menuItems = menuItemRepository.findAllByRestaurantId(id);
		
		return menuItems;
	}

	public void bulkUpdate(Long restaurantId, List<MenuItem> menuItems) {
		// TODO Auto-generated method stub
		for (MenuItem menuItem : menuItems) {
			update(restaurantId, menuItem);
		}
	}

	private void update(Long restaurantId, MenuItem menuItem) {
		if(menuItem.isDestroy()) {
			menuItemRepository.deleteById(menuItem.getId());
			return;
		}
		
		menuItem.setRestaurantId(restaurantId);
		menuItemRepository.save(menuItem);
	}

}
