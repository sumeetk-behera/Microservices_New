package com.example.service.user.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<?> dataNotFound(DataNotFoundException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}

}
