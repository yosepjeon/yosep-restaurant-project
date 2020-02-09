package com.yosep.restaurant.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RegionTests {

	@Test
	public void creation() {
		Region region = Region.builder().name("서울").build();
		
		assertThat(region.getName(), is("서울"));
	}

}
