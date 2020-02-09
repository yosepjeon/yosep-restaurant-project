package com.yosep.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem {
	@Id
	@GeneratedValue
	private Long id;
	
	private Long restaurantId;
	
	private String name;
	
	@Transient
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private boolean destroy;
}
