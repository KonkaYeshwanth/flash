package com.micro.boot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.micro.boot.Exception.UserNotFoundException;
import com.micro.boot.model.User;
import com.micro.boot.service.UserServiceImpl;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping(path = "/adduser")
	@ResponseBody
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User u = userServiceImpl.addUser(user);
//		ResponsePojo response=new ResponsePojo();
//		if(u.getName() !=null) {
//			response.setStatus("User successfully added");
//		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(u.getName())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping(path = "users")
	@ResponseBody
	public List<User> getUsers() {
		return userServiceImpl.listUsers();
	}

	@GetMapping(path = "/finduser/{name}")
	@ResponseBody
	public User findUserByName(@PathVariable String name) {
		User user=userServiceImpl.findUser(name);
		if(user == null) {
			throw new UserNotFoundException("User not existed");
		}
		return user ;

	}
}
