package com.yosep.restaurant.application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import com.yosep.restaurant.domain.MenuItem;
import com.yosep.restaurant.domain.MenuItemRepository;
import com.yosep.restaurant.domain.Restaurant;
import com.yosep.restaurant.domain.RestaurantRepository;

class RestaurantServiceTest {
	private RestaurantService restaurantService;
//	private RestaurantRepository restaurantRepository;
//	private MenuItemRepository menuItemRepository;
	@Mock
	private RestaurantRepository restaurantRepository;
	@Mock
	private MenuItemRepository menuItemRepository;

	// 이 테스트는 스프링의 테스트가 아니기 때문에 계속해서 에러를 뱉어낸다.
	@BeforeTestExecution
	public void setUp() {
		MockitoAnnotations.initMocks(this); // 현재 @Mock이 붙어있는 것들을 초기화해줌.
		mockRestaurantRepository();
		mockMenuItemRepository();
//		restaurantRepository = new RestaurantRepositoryImpl();
//		menuItemRepository = new MenuItemRepositoryImpl();
		restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
	}

	private void mockMenuItemRepository() {
		// TODO Auto-generated method stub
		List<MenuItem> menuItems = new ArrayList<>();
		menuItems.add(MenuItem.builder().name("BigMac").build());
		given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItems);
	}

	private void mockRestaurantRepository() {
		List<Restaurant> restaurants = new ArrayList<>();
//		Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
		Restaurant restaurant = Restaurant.builder()
				.id(1004L)
				.name("Bob zip")
				.address("Seoul")
				.menuItems(new ArrayList<>())
				.build();
		restaurants.add(restaurant);

		given(restaurantRepository.findAll()).willReturn(restaurants);
		given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurant));
	}

	@Test
	public void getRestaurant() {
//		restaurantRepository = new RestaurantRepositoryImpl();
//		menuItemRepository = new MenuItemRepositoryImpl();
//		restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
		setUp();
		// restaurantService.getRestaurant(1004L);
		Restaurant restaurant = restaurantService.getRestaurant(1004L);

		assertThat(restaurant.getId(), is(1004L));
	}
	
//	@Test
//	public void detail() throws Exception {
//		Restaurant restaurant1 = new Restaurant(1004L,"JOKER House", "Seoul");
//		restaurant1.setMenuItems(Arrays.asList(new MenuItem("Kimchi")));
//		
//		Restaurant restaurant2 = new Restaurant(2020L, "Cyber Food", "Seoul");
//		
//		given(restaurantService.getRestaurant(1004L)).willReturn(restaurant1);
//		given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);
//		
//	}

	@Test
	public void getRestaurants() {
//		restaurantRepository = new RestaurantRepositoryImpl();
//		menuItemRepository = new MenuItemRepositoryImpl();
//		restaurantService = new RestaurantService(restaurantRepository,menuItemRepository);

		setUp();
		List<Restaurant> restaurants = restaurantService.getRestaurants();
		System.out.println(menuItemRepository.findAllByRestaurantId(1004L).get(0).getName());

		Restaurant restaurant = restaurants.get(0);
		assertThat(restaurant.getId(), is(1004L));

//		MenuItem menuItem = restaurant.getMenuItems().get(0);
//		assertThat(menuItem.getName(), is("BigMac"));
	}

	@Test
	public void addRestaurant() {
		setUp();

//		Restaurant restaurant = new Restaurant("BeRyong", "Busan");
		Restaurant restaurant = Restaurant.builder()
				.name("BeRyong")
				.address("Busan")
				.build();
//		Restaurant saved = new Restaurant(1234L, "BeRyong", "Busan");
		Restaurant saved = Restaurant.builder()
				.id(1234L)
				.name("BeRyong")
				.address("Busan")
				.build();
		given(restaurantRepository.save(null)).willReturn(saved);

		Restaurant created = restaurantService.addRestaurant(restaurant);

		assertThat(saved.getId(), is(1234L));
	}

	@Test
	public void updateRestaurant() {
		setUp();
//		Restaurant restaurant = new Restaurant(1004L, "BobZip", "Seoul");
		Restaurant restaurant = Restaurant.builder()
				.id(1004L)
				.name("Bob zip")
				.address("Seoul")
				.build();
		given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurant));

		restaurantService.updateRestaurant(1004L, "Sool zip", "Busan");
		
		assertThat(restaurant.getName(), is("Sool zip"));
		assertThat(restaurant.getAddress(), is("Busan"));
	}
}
