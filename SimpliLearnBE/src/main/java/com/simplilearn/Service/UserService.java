package com.simplilearn.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplilearn.Entity.Users;
import com.simplilearn.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepository repo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "fail";
        }
    }
    
    // Getting all users from the database
    public Collection<Users> getAllUser() {
    	return repo.findAll();
    }
    
    // getting signle user from database using Username
    public Users findByUsername(String username) {
    	return repo.findByUsername(username);
    }
    
    public String deleteUser(String username) {
    	Users user = repo.findByUsername(username);
    	if( user == null ) {
    		return "User not found with username " + username;
    	}
    	repo.deleteById(user.getId());
    	return "User Deleted Successfully!";
    }
}
