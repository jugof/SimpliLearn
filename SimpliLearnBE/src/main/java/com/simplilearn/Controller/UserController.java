package com.simplilearn.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.Entity.Users;
import com.simplilearn.Service.UserService;

@CrossOrigin
@RestController
@RequestMapping
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public Users register( @RequestBody Users user) {
		return service.register(user);
	}
	
	@PostMapping("/login")
	public String login( @RequestBody Users user) {
		return service.verify(user);
	}
	
	@GetMapping("/test")
	public String message() {
		return "Testing the JWT Integration with my Spring Boot Project";
	}
	
	@GetMapping("/allusers")
	public Collection<Users> getAllUser(){
		return service.getAllUser();
	}
	
	@GetMapping("/username/{username}")
	public Users findByUsername( @PathVariable String username) {
		return service.findByUsername(username);
	}
	
	@DeleteMapping("/username/{username}")
	public String deleteUser( @PathVariable String username) {
		return service.deleteUser(username);
	}
}
