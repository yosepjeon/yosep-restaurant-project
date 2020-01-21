package com.yosep.restaurant.interfaces;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yosep.restaurant.application.RestaurantService;
import com.yosep.restaurant.domain.MenuItem;
import com.yosep.restaurant.domain.MenuItemRepository;
import com.yosep.restaurant.domain.Restaurant;
import com.yosep.restaurant.domain.RestaurantRepository;

// UI Layer는 사용자와 내부에 있는 비즈니스 로직 또는 도메인 모델들이 서로 상관없도록 징검다리 역할만 하도록 하고,
// 실제로 로직을 수행하는 것들은 비지니스 혹은 도메인 모델에 있도록 하는 것.
@RestController
public class RestaurantController {
//	private RestaurantRepository repository = new RestaurantRepository();
//	@Autowired
//	private RestaurantRepository restaurantRepository;
//	@Autowired
//	private MenuItemRepository menuItemRepository;
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/restaurants")
	public List<Restaurant> list() {
//		List<Restaurant> restaurants = new ArrayList<>();
//		restaurants.add(new Restaurant(1004L, "Mcdonald", "Seoul"));
//		restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));

//		List<Restaurant> restaurants = restaurantRepository.findAll();
		List<Restaurant> restaurants = restaurantService.getRestaurants();

		return restaurants;
	}

	@GetMapping("/restaurants/{id}")
	public Restaurant detail(@PathVariable("id") Long id) {
//		List<Restaurant> restaurants = new ArrayList<>();
//		restaurants.add(new Restaurant(1004L, "Mcdonald", "Seoul"));
//		restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
//		List<Restaurant> restaurants = repository.findAll();

//		레스토랑들을 가져와서 id값을 이용해서 특정 레스토랑을 찾고 있는데 이것은 컨트롤러의 역할이 아니다.
//		Repository의 findById()라는 메소드로 책임을 위임
//		Restaurant restaurant = restaurants.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
//		Restaurant restaurant = restaurantRepository.findById(id);
		
//		기존의 레파지토리는 컬렉션의 역할을 해왔지만 이러한 여러가지 컬렉션 기능들을 복합적으로 수행시키기 위해 서비스 객체 이용
		Restaurant restaurant = restaurantService.getRestaurant(id);
		
		
//		List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
//		System.out.println("menuItems.size(): " + menuItems.size());
//		restaurant.setMenuItems(menuItems);
//		restaurant.addMenuItem(new MenuItem("BigMac"));

		return restaurant;
	}
	
	@PostMapping("/restaurants")
	public ResponseEntity<?> create(@RequestBody Restaurant resource) throws URISyntaxException {
		String name = resource.getName();
		String address = resource.getAddress();
		
		Restaurant restaurant = new Restaurant(name,address);
		restaurantService.addRestaurant(restaurant);
		
		URI location = new URI("/restaurants/1234");
		return ResponseEntity.created(location).body("{}");
	}
}
