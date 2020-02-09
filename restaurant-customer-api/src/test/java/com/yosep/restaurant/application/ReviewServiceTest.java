package com.yosep.restaurant.application;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yosep.restaurant.domain.Review;
import com.yosep.restaurant.domain.ReviewRepository;

public class ReviewServiceTest {

	private ReviewService reviewService;
	
	@Mock
	private ReviewRepository reviewRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		reviewService = new ReviewService(reviewRepository);
	}

	@Test
	public void addReview() {
		Review review = Review.builder()
				.name("JOKER")
				.score(3)
				.description("Mat-it-da")
				.build();
		
		reviewService.addReview(1004L,review);
		
		verify(reviewRepository).save(any());
	}

}
