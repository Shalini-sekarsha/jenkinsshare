package com.demo.sharemarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.demo.sharemarket.modal.User;
import com.demo.sharemarket.service.EmailService;
import com.demo.sharemarket.service.UserService;



 

 
@RestController

@CrossOrigin("*")

@RequestMapping("/user")

public class UserController {
 
	@Autowired

	UserService userservice;
	// Service to handle email sending
//
//	    @PostMapping("/doUserInsert")
//	    public ResponseEntity<User> insertUser(@RequestBody User newUser) {
//	        // Insert the new user
//	        User savedUser = userservice.insertUser(newUser);
//
//	        // Send an email to the new user
//	        String email = savedUser.getUserEmail();
//	        String subject = "Welcome!";
//	        String text = "Thank you for registering to Sharemarket, " + savedUser.getUserName() + "!";
//
//	        try {
//	            emailService.sendEmail(email, subject, text);
//	        } catch (Exception e) {
//	            // Handle email sending failure
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                                 .body(null); // or return an appropriate error message
//	        }
//
//	        return ResponseEntity.ok(savedUser);
//	    }
//	
	
//	@PostMapping("/doUserInsert")
//
//	public User insertUser(@RequestBody User newUser) {
//
//		return userservice.insertUser(newUser);
// 
//	}
	  
	  @Autowired
	    private EmailService emailService;

	    @PostMapping("/doUserInsert")
	    public User insertUser(@RequestBody User newUser) {
	        User user = userservice.insertUser(newUser);
	        emailService.sendRegistrationEmail(user.getUserEmail()); // Assuming User has a getEmail method
	        return user;
	    }
	  
	  
	  
	  
//
//	    @PostMapping("/doUserInsert")
//	    public ResponseEntity<?> registerUser( @RequestBody User user) {
//	        try {
//	            userservice.insertUser(user);
//	            return ResponseEntity.ok("User registered successfully");
//	        } catch (Exception e) {
//	            // Log the exception and return an error response
//	            e.printStackTrace();
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
//	        }
//	    }


	@PutMapping("/updateUser")

	public User updateUser(@RequestBody User user) {
 
		return userservice.updateUser(user);

	}

	@GetMapping("/getAllUserList")

	public List<User> getUsers() {

		return userservice.getUsers();

	}
 
	

	@GetMapping("/GetByUserId/{userId}")

	public User find(@PathVariable("userId") int userId) {

		return userservice.userfind(userId);

	}

	@GetMapping("/currentUser")
	public ResponseEntity<User> getCurrentUser() {
	    
	    User currentUser = userservice.getCurrentUser();
	    if (currentUser != null) {
	        return ResponseEntity.ok(currentUser);
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }
	}


 
	@GetMapping("/loginUser/{userEmail}/{userPassword}")

	public  User  loginUser(@PathVariable("userEmail") String userEmail,

			@PathVariable("userPassword") String userPassword) {
 
		User existingUser = userservice.findByuserName(userEmail);
		try {
			if (existingUser != null && userPassword.equals(existingUser.getUserPassword())) {
				return existingUser;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
 
	}
	
	}
	
