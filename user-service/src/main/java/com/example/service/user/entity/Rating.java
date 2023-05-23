package com.example.service.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	
	private String id;
	private Integer user;
	private Integer hotel;
	private Integer ratingOf10;
	private String feedback;
	
	private Hotel hotels;

}
