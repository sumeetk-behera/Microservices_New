package com.example.service.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.hotel.entity.Hotel;
import com.example.service.hotel.repository.HotelRepository;
import com.example.service.user.exception.DataNotFoundException;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getById(Integer hotelId) {
		return hotelRepository.findById(hotelId)
				.orElseThrow(() -> new DataNotFoundException("Invalid Hotel Id" + hotelId));
	}

}
