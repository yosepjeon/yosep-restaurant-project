package com.yosep.restaurant.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yosep.restaurant.domain.Category;
import com.yosep.restaurant.domain.CategoryRepository;
import com.yosep.restaurant.domain.Region;

@Service
public class CategoryService {
	
	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		// TODO Auto-generated constructor stub
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		List<Category> category = categoryRepository.findAll();
		
		return category;
	}

	public Category addCategory(String name) {
		// TODO: 구현 필요함.
		Category category = Category.builder().name(name).build();
		
		categoryRepository.save(category);
		
		return category;
	}

}
