package com.demo.sharemarket.service;

import java.util.List;

import com.demo.sharemarket.modal.User;



public interface UserService {
 
	public User insertUser(User newUser);
 
	public User updateUser(User user);
 
	public List<User> getUsers();
 
	public User userfind(int userId);
 
	public List<Integer> getUserIdlist();
//	public User login(String userName, String userPassword);
 
	public List<User> searchUser(String userName);
 
	public User userLogin(String userEmail, String userPassword);
	public User findByuserName(String userName);

	public User getCurrentUser();
}

 

