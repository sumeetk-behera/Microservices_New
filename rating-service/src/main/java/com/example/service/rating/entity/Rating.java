package com.example.service.rating.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("user-ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	@Id
	private String id;
	private Integer user;
	private Integer hotel;
	private Integer ratingOf10;
	private String feedback;

}
