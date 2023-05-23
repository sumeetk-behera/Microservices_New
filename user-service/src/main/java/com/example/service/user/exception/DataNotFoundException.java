package com.example.service.user.exception;

@SuppressWarnings("serial")
public class DataNotFoundException extends RuntimeException {

	public DataNotFoundException(String message) {
		super(message);
	}

}
