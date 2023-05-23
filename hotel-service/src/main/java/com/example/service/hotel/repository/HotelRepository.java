package com.example.service.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.service.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
