package com.yosep.restaurant.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

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
	public void getReviews() {
		List<Review> mockReviews = new ArrayList<>();
		mockReviews.add(Review.builder().description("Cool!").build());
		
		given(reviewRepository.findAll()).willReturn(mockReviews);
		
		List<Review> reviews = reviewService.getReviews();
		
		Review review = reviews.get(0);
		
		assertThat(review.getDescription(),is("Cool!"));
	}

}
