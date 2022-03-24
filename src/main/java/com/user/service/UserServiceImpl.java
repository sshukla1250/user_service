package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;



@Service
public class UserServiceImpl implements UserService{

	//fake user list
	
	List<User>list=List.of(
			new User(1211L,"Sandeep","8999405"),
			new User(1212L,"Kuldeep","8999711"),
            new User(1214L,"Manoj","990391224")
            );
	@Override
	public User getUser(Long id) {
		
		return list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
	}

}
