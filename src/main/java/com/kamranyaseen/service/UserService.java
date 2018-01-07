package com.kamranyaseen.service;

import java.util.List;

import com.kamranyaseen.model.User;


public interface UserService {

	User save(User user);
	List<User> findAll();
	void delete(long id);
}
 