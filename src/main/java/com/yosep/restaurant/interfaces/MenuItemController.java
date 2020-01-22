package com.yosep.restaurant.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yosep.restaurant.application.MenuItemService;
import com.yosep.restaurant.domain.MenuItem;

@RestController
public class MenuItemController {
	@Autowired
	private MenuItemService menuItemService;
	
	@PatchMapping("/restaurants/{restaurantId}/menuitems")
	public String buldUpdate(@PathVariable("restaurantId")Long restaurantId,@RequestBody List<MenuItem> menuItems) {
		menuItemService.bulkUpdate(restaurantId,menuItems);
		
		return "";
	}
}
