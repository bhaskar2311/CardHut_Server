package com.lti.service;

import java.util.List;

import com.lti.entity.User;

public interface UserService {
	String addOrUpdateUser(User user);
	User getUserById(int userId);
	List<User> viewAllUsers();
	String login(int userId,String password);
	
	String addJoiningFee(int userId,double joiningFee);

}
