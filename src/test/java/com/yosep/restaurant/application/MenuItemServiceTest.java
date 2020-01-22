package com.yosep.restaurant.application;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yosep.restaurant.domain.MenuItem;
import com.yosep.restaurant.domain.MenuItemRepository;

public class MenuItemServiceTest {

	private MenuItemService menuItemService;

	@Mock
	MenuItemRepository menuItemRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		menuItemService = new MenuItemService(menuItemRepository);
	}

	@Test
	public void bulkUpdate() {
		List<MenuItem> menuItems = new ArrayList<>();

		menuItems.add(MenuItem.builder().name("Kimch").build()); // 새로 추가
		menuItems.add(MenuItem.builder().id(12L).name("Gukbob").build()); // 업데이트
		menuItems.add(MenuItem.builder().id(1004L).destroy(true).build()); // 삭제

		menuItemService.bulkUpdate(1L, menuItems);

		verify(menuItemRepository,times(2)).save(any());
		verify(menuItemRepository,times(1)).deleteById(eq(1004L));
	}

}
