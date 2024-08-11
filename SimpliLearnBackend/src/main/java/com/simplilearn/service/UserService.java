package com.simplilearn.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.UserEntity;
import com.simplilearn.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepoRef;
	
	// CRUD create
	public UserEntity addUser(UserEntity user) {
		user.setId(UUID.randomUUID().toString().split("-")[0]);
		return userRepoRef.save(user);
	}
	
	// read
	public List<UserEntity> findAllUsers() {
		return userRepoRef.findAll();
	}
	
	// update
	public UserEntity updateUser(UserEntity userReq) {
		//get the existing document from db 
		//populate new value from req from object/entity/documnet
		UserEntity existingUserEntity = userRepoRef.findById(userReq.getId()).get();
		existingUserEntity.setName(userReq.getName());
		existingUserEntity.setPassword(userReq.getPassword());
		
		return userRepoRef.save(existingUserEntity);
	}
	
	// Delete
	public String deleteUser(String userId) {
		userRepoRef.deleteById(userId);
		return userId + " Task deleted from dashboard ";
	}
	
}
