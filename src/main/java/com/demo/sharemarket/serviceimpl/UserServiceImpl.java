package com.demo.sharemarket.serviceimpl;


import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.sharemarket.modal.User;
import com.demo.sharemarket.repository.UserRepo;
import com.demo.sharemarket.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
 
	@Autowired
	UserRepo userdao;
 
	public User insertUser(User newUser) {
		return userdao.insertUser(newUser);
 
	}
 
	public User updateUser(User user) {
		return userdao.updateUser(user);
	}
 
	@Override
	public List<User> getUsers() {
		return userdao.getUsers();
	}
 
	@Override
	public User userfind(int userId) {
		return userdao.userfind(userId);
	}
 
	@Override
	public List<Integer> getUserIdlist() {
		return userdao.getUserIdlist();
	}
 
	public List<User> searchUser(String userName) {
		return userdao.searchUser(userName);
	}
 
	public User userLogin(String userEmail, String userPassword) {
		return userdao.userLogin(userEmail, userPassword);
	}
	
	@Override
	public com.demo.sharemarket.modal.User findByuserName(String userName) {
		return userdao.findByuserName(userName);
	}

	@Override
	public User getCurrentUser() {
		
		return userdao.getCurrentUser();
	}
}
 





