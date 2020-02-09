package com.yosep.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Review {
	@Id
	@GeneratedValue
	Long id;
	
	@Setter
	private Long restaurantId;
	
	@NotEmpty
	private String name;
	
	@Max(5)
	@Min(0)
	@NotNull
	private Integer score;
	
	@NotEmpty
	private String description;
}
