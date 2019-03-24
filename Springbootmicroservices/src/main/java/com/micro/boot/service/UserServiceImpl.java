package com.micro.boot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.micro.boot.model.User;

@Component
public class UserServiceImpl implements UserService {

	private static List<User> users = new ArrayList<User>();

	 List<User> immutableusers = Collections.unmodifiableList(users);

	public static int countUsers = users.size();

	@Override
	public User addUser(User user) {
		if (user.getId() == null) {
			user.setId(++countUsers);
		}

		users.add(user);
		return user;
	}
	
	@Override
	public List<User> listUsers(){
		return  immutableusers;
	}

	@Override
	public User findUser(String name) {
		Predicate<User> namePredicate=user ->user.getName().equalsIgnoreCase(name);
		User user=users.stream().filter(namePredicate).findAny().orElse(null);
		return user;
	}

}
