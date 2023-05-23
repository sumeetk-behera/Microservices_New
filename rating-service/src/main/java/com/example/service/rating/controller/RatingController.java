package com.example.service.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.rating.entity.Rating;
import com.example.service.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping("/create")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		return ResponseEntity.ok(ratingService.create(rating));

	}

	@GetMapping("/list")
	public ResponseEntity<List<Rating>> getAll() {
		return ResponseEntity.ok(ratingService.getAll());

	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getByUserId(@PathVariable Integer userId){
		return ResponseEntity.ok(ratingService.getByUserID(userId));
		
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getByHotelId(@PathVariable Integer hotelId){
		return ResponseEntity.ok(ratingService.getByHotelId(hotelId));
		
	}
	

}
