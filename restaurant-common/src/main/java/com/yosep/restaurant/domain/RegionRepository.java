package com.yosep.restaurant.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region, Long> {
	
	List<Region> findAll();
}
