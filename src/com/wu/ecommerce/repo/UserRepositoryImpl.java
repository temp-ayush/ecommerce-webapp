package com.wu.ecommerce.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.utils.DBUtils;

public class UserRepositoryImpl implements UserRepository {
	
	
	private UserRepositoryImpl() {
//		pvt constructor
	}
	
	private static UserRepository userRepository;
	
//	private ArrayList<User> users = new ArrayList<User>();
	
	public static UserRepository getInstance() {
		if(userRepository == null) {
//			create the object;
			userRepository = new UserRepositoryImpl();
		}
		return userRepository;
	}
	@Override
	public User addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		String insertQuery = "insert into users (userid, firstname, lastname, contact, address) values (? , ? , ? , ? , ?)";
		Connection connection = DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		
		preparedStatement.setString(1, user.getUserId());
		preparedStatement.setString(2, user.getFirstName());
		preparedStatement.setString(3, user.getLastName());
		preparedStatement.setString(4, user.getContact());
		preparedStatement.setString(5, user.getAddress());
		
		int result = preparedStatement.executeUpdate();
		
		if( result > 0) {
			return user;
		}
		return null;
	}

	@Override
	public Optional<User> getUserByUserId(String id) {
		// TODO Auto-generated method stub
//		return users.stream().filter(e-> e.getUserId().equals(id)).findFirst();
		return null;
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
