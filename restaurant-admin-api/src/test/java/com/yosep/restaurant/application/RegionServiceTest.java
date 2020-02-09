package com.yosep.restaurant.application;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yosep.restaurant.domain.Region;
import com.yosep.restaurant.domain.RegionRepository;

public class RegionServiceTest {

	private RegionService regionService;
	
	@Mock
	private RegionRepository regionRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		regionService = new RegionService(regionRepository);
	}

	@Test
	public void getRegions() {
		List<Region> mockRegions = new ArrayList<Region>();
		mockRegions.add(Region.builder().name("Seoul").build());
		
		given(regionRepository.findAll()).willReturn(mockRegions);
		
		List<Region> regions = regionService.getRegions();

		Region region = regions.get(0);

		assertThat(region.getName(), is("Seoul"));
	}
	
	@Test
	public void addRegion() {
		Region region=regionService.addRegion("Seoul");
		
		verify(regionRepository).save(any());
		
		assertThat(region.getName(), is("Seoul"));
	}

}
