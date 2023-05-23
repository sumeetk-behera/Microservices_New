package com.example.service.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.user.entity.User;
import com.example.service.user.service.UserService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.saveUser(user));

	}

	@GetMapping("/list")
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok(userService.getAll());
	}

	int retryCount = 1;
	@GetMapping("/{userId}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
//	@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallBack")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallBack")
	public ResponseEntity<User> getById(@PathVariable Integer userId) {
		System.err.println(retryCount);
		retryCount++;
		return ResponseEntity.ok(userService.getById(userId));

	}


	// CREATING FALLBACK METHOD FOR CIRCUIT-BREAKER(ratingHotelBreaker) ABOVE
	public ResponseEntity<User> ratingHotelFallBack(Integer userId, Exception e) {
		return ResponseEntity.badRequest()
				.body(new User(userId, "FallBack", "dummy@gmail.com", "FallBack Executed As Service is down", null));

	}

}
