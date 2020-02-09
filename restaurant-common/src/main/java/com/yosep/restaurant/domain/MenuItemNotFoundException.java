package com.yosep.restaurant.domain;

public class MenuItemNotFoundException extends RuntimeException{
	public MenuItemNotFoundException(long id) {
		// TODO Auto-generated constructor stub
		super("Could not find menuItem " + id);
	}
}
