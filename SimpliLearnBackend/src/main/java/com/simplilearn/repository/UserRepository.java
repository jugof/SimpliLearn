package com.simplilearn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.simplilearn.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
	
}
