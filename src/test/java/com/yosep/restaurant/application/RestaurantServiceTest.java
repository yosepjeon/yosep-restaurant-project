package com.yosep.restaurant.application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.yosep.restaurant.domain.MenuItem;
import com.yosep.restaurant.domain.MenuItemRepository;
import com.yosep.restaurant.domain.MenuItemRepositoryImpl;
import com.yosep.restaurant.domain.Restaurant;
import com.yosep.restaurant.domain.RestaurantRepository;
import com.yosep.restaurant.domain.RestaurantRepositoryImpl;

class RestaurantServiceTest {
	private RestaurantService restaurantService;
	private RestaurantRepository restaurantRepository;
	private MenuItemRepository menuItemRepository;

	// 이 테스트는 스프링의 테스트가 아니기 때문에 계속해서 에러를 뱉어낸다.
	@Before
	public void setUp() {
		restaurantRepository = new RestaurantRepositoryImpl();
		menuItemRepository = new MenuItemRepositoryImpl();
		restaurantService = new RestaurantService(restaurantRepository,menuItemRepository);
	}

	@Test
	public void getRestaurant() {
		restaurantRepository = new RestaurantRepositoryImpl();
		menuItemRepository = new MenuItemRepositoryImpl();
		restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
//		restaurantService.getRestaurant(1004L);
		Restaurant restaurant = restaurantService.getRestaurant(1004L);

		assertThat(restaurant.getId(), is(1004L));
	}

	@Test
	public void getRestaurants() {
		restaurantRepository = new RestaurantRepositoryImpl();
		menuItemRepository = new MenuItemRepositoryImpl();
		restaurantService = new RestaurantService(restaurantRepository,menuItemRepository);

		List<Restaurant> restaurants = restaurantService.getRestaurants();
		System.out.println(menuItemRepository.findAllByRestaurantId(1004L).get(0).getName());
		
		Restaurant restaurant = restaurants.get(0);
		assertThat(restaurant.getId(), is(1004L));

//		MenuItem menuItem = restaurant.getMenuItems().get(0);
//		assertThat(menuItem.getName(), is("BigMac"));
	}
}
