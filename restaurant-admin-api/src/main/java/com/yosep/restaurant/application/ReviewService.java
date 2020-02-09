package com.yosep.restaurant.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yosep.restaurant.domain.Review;
import com.yosep.restaurant.domain.ReviewRepository;

@Service
public class ReviewService {
	
	private ReviewRepository reviewRepository;
	
	@Autowired
	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	public Review addReview(Long restaurantId, Review review) {
		review.setRestaurantId(restaurantId);
		return reviewRepository.save(review);
	}

	public List<Review> getReviews() {
		// TODO Auto-generated method stub
		
		return reviewRepository.findAll();
	}
}
