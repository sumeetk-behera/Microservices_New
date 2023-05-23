package com.example.service.rating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.rating.entity.Rating;
import com.example.service.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating create(Rating rating) {
//		rating.setId(ratingRepository.getNextId());
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getByUserID(Integer userId) {
		return ratingRepository.findByUser(userId);
	}

	@Override
	public List<Rating> getByHotelId(Integer hotelId) {
		return ratingRepository.findByHotel(hotelId);
	}
}
