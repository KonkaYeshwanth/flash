package com.micro.boot.service;

import java.util.List;

import com.micro.boot.model.User;

public interface UserService {
	
	User addUser(User user);
     
	List<User> listUsers();
	
	User findUser(String name);
}
