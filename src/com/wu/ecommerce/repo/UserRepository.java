package com.wu.ecommerce.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.User;

public interface UserRepository {
	public User addUser(User user) throws SQLException;
	public Optional<User> getUserByUserId (String id);
	public Optional<ArrayList<User>> getUsers();
	public Optional<ArrayList<User>> getAllUsersByAddress(String address);
	public String removeUserByUserId(String id);
	public User updateUserByUserId (String id, User user);
}
