package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Contact;
import com.user.entity.User;
import com.user.service.UserService;


@RestController
@RequestMapping("/user")
public class UserCtl {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/{userId}")
	public User getName(@PathVariable("userId") Long userId) {
		User user=this.userService.getUser(userId);
		
		List<Contact> contacts=this.restTemplate.getForObject("http://Contact-Service/contact/user/".concat(""+userId), List.class);
	   
		user.setContact(contacts);
		
		return user;
	}

}
