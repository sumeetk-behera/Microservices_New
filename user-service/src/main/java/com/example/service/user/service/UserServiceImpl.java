package com.example.service.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.service.user.entity.Hotel;
import com.example.service.user.entity.Rating;
import com.example.service.user.entity.User;
import com.example.service.user.exception.DataNotFoundException;
import com.example.service.user.feignServices.HotelService;
import com.example.service.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelFeign;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAll() {
		List<User> findAll = userRepository.findAll();
		List<Rating> forObject = restTemplate.getForObject("http://localhost:8083/rating/list", List.class);
		findAll.forEach(user -> user.setRatings(forObject));
		return findAll;
	}

	@Override
	public User getById(Integer userId) {

//-------Get User From Database--------
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new DataNotFoundException("Invalid UserID " + userId));

//1.------Fetch Rating of the User From Rating Service-------- 
//		List<Rating> forObject = restTemplate.getForObject("http://localhost:8083/rating/user/" + user.getUserId(),
//				List.class);  Gave RunTime Exception As in below line when we r using map to collect the list it changes the list to linkedHashSet

//		---------Java 8 map with list-------
//		List<Rating> collect = forObject.stream().map(rating -> {
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotel/"+rating.getHotelId(), Hotel.class);
//			Hotel body = forEntity.getBody();
//			rating.setHotel(body);
//			return rating;
//		}).collect(Collectors.toList());

//2.---TO AVOID CLASS CAST EXCEPTION OF CONERTING LINKED HASH MAP--Here We are not converting rating into list directly, rather to array[] of object.
//		    Rating[] forObject = restTemplate.getForObject("http://localhost:8083/rating/user/" + user.getUserId(), Rating[].class);
		Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getUserId(),
				Rating[].class);

//---------Converting Rating ARRAY[] into LIST using utility class name Arrays.
		List<Rating> list = Arrays.stream(forObject).toList();

//---------------Java 8 forEach with list--------------- 
		List<Rating> ratingss = new ArrayList<>();
		list.forEach(rating -> {

//	--------------REMOVED LOCALHOST:PORT_NO WITH MICROSERVICE NAME using @loadBalanced------------
//			Hotel forObject2 = restTemplate.getForObject("http://localhost:8082/hotel/" + rating.getHotel(), Hotel.class);
			Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/" + rating.getHotel(), Hotel.class);
//			Hotel hotel = hotelFeign.getHotel(rating.getHotel());  //Feign Client

			rating.setHotels(hotel);
			ratingss.add(rating);
		});

		user.setRatings(ratingss);
		return user;
	}

}
