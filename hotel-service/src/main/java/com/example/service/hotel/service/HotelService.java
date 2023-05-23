package com.example.service.hotel.service;

import java.util.List;

import com.example.service.hotel.entity.Hotel;

public interface HotelService {

	
	Hotel saveHotel(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel getById(Integer hotelId);
}
