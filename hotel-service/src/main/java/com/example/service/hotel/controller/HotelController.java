package com.example.service.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.hotel.entity.Hotel;
import com.example.service.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/save")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		return ResponseEntity.ok(hotelService.saveHotel(hotel));
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Hotel>> getAll(){
		return ResponseEntity.ok(hotelService.getAll());
		
	}
	
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getById(@PathVariable Integer hotelId){
		return ResponseEntity.ok(hotelService.getById(hotelId));
		
	}

}
