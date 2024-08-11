package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.UserEntity;
import com.simplilearn.service.UserService;


@RestController
@CrossOrigin
@RequestMapping("/v0.1")
public class UserController {
	
	@Autowired
	private UserService userServiceRef;
	
	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public UserEntity addUser( @RequestBody UserEntity user) {
		return userServiceRef.addUser(user);
	}
	
	@GetMapping("/user")
	public List<UserEntity> findAllUsers(){
		return userServiceRef.findAllUsers();
	}
	
	@PutMapping("/user")
	public UserEntity updateUserEntity( @RequestBody UserEntity userReq) {
		return userServiceRef.updateUser(userReq);
	}
	
	@DeleteMapping("/user/{userId}")
	public String deleteUser( @PathVariable String userId) {
		return deleteUser(userId);
	}
}
