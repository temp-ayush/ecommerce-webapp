package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.User;

public interface UserService {
	public User addUser(User user) throws SQLException;
	public Optional<User> getUserByUserId (String id);
	public Optional<ArrayList<User>> getUsers();
	public Optional<ArrayList<User>> getAllUsersByAddress(String address);
	public String removeUserByUserId(String id);
	public User updateUserByUserId (String id, User user);
}
