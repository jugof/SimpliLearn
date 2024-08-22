package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	
	public Users findByUsername(String username);
	
}
