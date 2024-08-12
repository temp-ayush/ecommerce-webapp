package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.repo.UserRepository;
import com.wu.ecommerce.repo.UserRepositoryImpl;

public class UserServiceImpl implements UserService {
	
private UserRepository userRepository = UserRepositoryImpl.getInstance();
	
	private UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserService userService;
	
	public static UserService getInstance() {
		if(userService == null) {
			userService = new UserServiceImpl();
		}
		
		return userService;
	}
	
	@Override
	public User addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userRepository.addUser(user);
	}

	@Override
	public Optional<User> getUserByUserId(String id) {
		// TODO Auto-generated method stub
		return userRepository.getUserByUserId(id);
	}

	@Override
	public Optional<ArrayList<User>> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ArrayList<User>> getAllUsersByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeUserByUserId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUserByUserId(String id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
