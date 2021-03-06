package com.yosep.restaurant.interfaces;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yosep.restaurant.application.RegionService;
import com.yosep.restaurant.domain.Region;

@RestController
public class RegionController {
	@Autowired
	RegionService regionService;
	
	@GetMapping("/regions")
	public List<Region> list() {
		List<Region> regions = regionService.getRegions();
		
		return regions;
	}
	
	@PostMapping("/regions")
	public ResponseEntity<?> create(@RequestBody Region resource) throws URISyntaxException {
		// TODO: 지역 생성
		String name = resource.getName();
		
		Region region = regionService.addRegion(name);
		
		String url = "/regions/" + region.getId();
		return ResponseEntity.created(new URI(url)).body("{}");
	}
}
