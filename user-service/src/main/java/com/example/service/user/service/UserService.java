package com.example.service.user.service;

import java.util.List;

import com.example.service.user.entity.User;

public interface UserService {

	User saveUser(User user);

	List<User> getAll();

	User getById(Integer userId);
}
