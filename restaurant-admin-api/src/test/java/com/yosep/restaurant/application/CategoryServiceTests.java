package com.yosep.restaurant.application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yosep.restaurant.domain.Category;
import com.yosep.restaurant.domain.CategoryRepository;

public class CategoryServiceTests {

	private CategoryService categoryService;
	
	@Mock
	private CategoryRepository categoryRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		categoryService = new CategoryService(categoryRepository);
	}

	@Test
	public void getCategories() {
		List<Category> mockCategories = new ArrayList<Category>();
		mockCategories.add(Category.builder().name("Korean Food").build());
		
		given(categoryRepository.findAll()).willReturn(mockCategories);
		
		List<Category> categories = categoryService.getCategories();

		Category category = categories.get(0);

		assertThat(category.getName(), is("Korean Food"));
	}
	
	@Test
	public void addCategory() {
		Category Category=categoryService.addCategory("Korean Food");
		
		verify(categoryRepository).save(any());
		
		assertThat(Category.getName(), is("Korean Food"));
	}

}
