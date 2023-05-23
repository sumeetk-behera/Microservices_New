package com.example.service.rating.service;

import java.util.List;

import com.example.service.rating.entity.Rating;

public interface RatingService {

	Rating create(Rating rating);
	
	List<Rating> getAll();
	
	List<Rating> getByUserID(Integer userId);
	
	List<Rating> getByHotelId(Integer hotelId);

}
