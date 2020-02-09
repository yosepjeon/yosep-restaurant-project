package com.yosep.restaurant.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yosep.restaurant.domain.RestaurantNotFoundException;

@ControllerAdvice
public class RestaurantErrorAdvice {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RestaurantNotFoundException.class)
	public String handleNotFound() {
		return "{}";
	}
}
