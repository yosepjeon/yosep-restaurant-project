package com.yosep.restaurant.interfaces;

import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.CoreMatchers.containsString;
//import com.yosep.restaurant.domain.RestaurantRepositoryImpl;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.yosep.restaurant.application.RestaurantService;
import com.yosep.restaurant.domain.MenuItem;
import com.yosep.restaurant.domain.Restaurant;
import com.yosep.restaurant.domain.RestaurantNotFoundException;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class) // Restaurant 컨트롤러를 테스트하겠다는 어노테이션
/*
 * 중요! @webMvcTest는 제대로된 저장소를 사용할 수 없기 때문에 테스트를 하기 위해서는
 * 직접 의존성을 주입해줘야 한다. @SpyBean 이용!!!
 */
public class RestaurantControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private RestaurantService restaurantService;
	
//	@SpyBean(RestaurantRepositoryImpl.class)
//	private RestaurantRepository restaurantRepository;
//
//	@SpyBean(MenuItemRepositoryImpl.class)
//	private MenuItemRepository menuItemRepository;
//	
//	@SpyBean(RestaurantService.class)
//	private RestaurantService restaurantService;
	
	@Test
	public void list() throws Exception {
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		restaurants.add(new Restaurant(1004L, "Mcdonald", "Seoul"));
		
		given(restaurantService.getRestaurants()).willReturn(restaurants);
		
		mvc.perform(get("/restaurants")).andExpect(status().isOk())
				.andExpect(content().string(containsString("\"id\":1004")))
				.andExpect(content().string(containsString("\"name\":\"Mcdonald\"")))
				.andExpect(content().string(containsString("\"address\":\"Seoul\"")));
	}
	
	@Test
	public void detailWithExisted() throws Exception {
		Restaurant restaurant1 = new Restaurant(1004L, "Joker House","Seoul");
		restaurant1.addMenuItem(MenuItem.builder().name("Kimchi").build());
		Restaurant restaurant2 = new Restaurant(2020L, "Cyber Food","Seoul");
		
		given(restaurantService.getRestaurant(1004L)).willReturn(restaurant1);
		given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);
		
		mvc.perform(get("/restaurants/1004"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("\"id\":1004")))
			.andExpect(content().string(containsString("\"name\":\"Joker House\"")))
			.andExpect(content().string(containsString("\"address\":\"Seoul\"")))
			.andExpect(content().string(containsString("Kimchi")));
	
		mvc.perform(get("/restaurants/2020"))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("\"id\":2020")))
		.andExpect(content().string(containsString("\"name\":\"Cyber Food\"")))
		.andExpect(content().string(containsString("\"address\":\"Seoul\"")));
	}
	
	@Test
	public void detailWithNotExisted() throws Exception {
		given(restaurantService.getRestaurant(404L))
			.willThrow(new RestaurantNotFoundException(404L));
		
		mvc.perform(get("/restaurants/404"))
			.andExpect(status().isNotFound())
			.andExpect(content().string("{}"));
	}
	
	@Test
	public void createWithValidData()throws Exception {
//		Restaurant restaurant = new Restaurant(1234L,"BeRyong","Seoul");
		given(restaurantService.addRestaurant(any())).will(invocation -> {
			Restaurant restaurant = invocation.getArgument(0);
			return Restaurant.builder()
					.id(1234L)
					.name(restaurant.getName())
					.address(restaurant.getAddress())
					.build();
		});
		
		mvc.perform(post("/restaurants")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Beryong\",\"address\":\"Busan\"}"))
			.andExpect(status().isCreated())
			.andExpect(header().string("location", "/restaurants/1234"))
			.andExpect(content().string("{}"));
		
		verify(restaurantService).addRestaurant(any());
	}
	
	@Test
	public void createWithInValidData()throws Exception {
		mvc.perform(post("/restaurants")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"\",\"address\":\"\"}"))
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void updateWithValidData() throws Exception {
		// 1004L, {"name":"JOKER Bar", "address":"Busan"}
		mvc.perform(patch("/restaurants/1004")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"JOKER Bar\", \"address\":\"Busan\"}"))
			.andExpect(status().isOk());
		
		verify(restaurantService).updateRestaurant(1004L,"JOKER Bar","Busan");
	}
	
	@Test
	public void updateWithInValidData() throws Exception {
		// 1004L, {"name":"JOKER Bar", "address":"Busan"}
		mvc.perform(patch("/restaurants/1004")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"\", \"address\":\"\"}"))
			.andExpect(status().isBadRequest());
	}
}
