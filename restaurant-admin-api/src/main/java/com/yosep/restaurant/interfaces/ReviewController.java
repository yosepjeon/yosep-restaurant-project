package com.yosep.restaurant.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yosep.restaurant.application.ReviewService;
import com.yosep.restaurant.domain.Review;

@RestController
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/reviews")
	public List<Review> list() {
		List<Review> reviews = reviewService.getReviews();
		
		return reviews;
	}
}
