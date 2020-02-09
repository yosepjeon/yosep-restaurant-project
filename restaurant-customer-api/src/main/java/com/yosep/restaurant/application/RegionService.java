package com.yosep.restaurant.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yosep.restaurant.domain.Region;
import com.yosep.restaurant.domain.RegionRepository;

@Service
public class RegionService {
	
	private RegionRepository regionRepository;
	
	@Autowired
	public RegionService(RegionRepository regionRepository) {
		// TODO Auto-generated constructor stub
		this.regionRepository = regionRepository;
	}

	public List<Region> getRegions() {
		// TODO Auto-generated method stub
		List<Region> regions = regionRepository.findAll();
		
		return regions;
	}
}
