package com.yosep.restaurant.interfaces;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.yosep.restaurant.application.RestaurantService;
import com.yosep.restaurant.domain.MenuItemRepository;
import com.yosep.restaurant.domain.MenuItemRepositoryImpl;
import com.yosep.restaurant.domain.RestaurantRepository;
import com.yosep.restaurant.domain.RestaurantRepositoryImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class) // Restaurant 컨트롤러를 테스트하겠다는 어노테이션
/*
 * 중요! @webMvcTest는 제대로된 저장소를 사용할 수 없기 때문에 테스트를 하기 위해서는
 * 직접 의존성을 주입해줘야 한다. @SpyBean 이용!!!
 */
public class RestaurantControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@SpyBean(RestaurantRepositoryImpl.class)
	private RestaurantRepository restaurantRepository;

	@SpyBean(MenuItemRepositoryImpl.class)
	private MenuItemRepository menuItemRepository;
	
	@SpyBean(RestaurantService.class)
	private RestaurantService restaurantService;
	
	@Test
	public void list() throws Exception {
		mvc.perform(get("/restaurants")).andExpect(status().isOk())
				.andExpect(content().string(containsString("\"id\":1004")))
				.andExpect(content().string(containsString("\"name\":\"Mcdonald\"")))
				.andExpect(content().string(containsString("\"address\":\"Seoul\"")));
	}
	
	@Test
	public void detail() throws Exception {
		mvc.perform(get("/restaurants/1004"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("\"id\":1004")))
			.andExpect(content().string(containsString("\"name\":\"Mcdonald\"")))
			.andExpect(content().string(containsString("\"address\":\"Seoul\"")))
			.andExpect(content().string(containsString("BigMac")));
	}
}
