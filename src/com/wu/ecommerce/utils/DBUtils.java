package com.wu.ecommerce.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	private DBUtils() {
		
	}
	
	public static DBUtils dbUtils;
	
	public static void main(String[] args) throws ClassNotFoundException {
		Properties properties = getInstance().loadProperties();
		System.out.println(properties);
		try {
			
			Connection connection = getInstance().getConnection();
			
			System.out.println("Connection is not equal to null");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static DBUtils getInstance() {
		if(dbUtils == null) {
			dbUtils = new DBUtils();
		}
		
		return dbUtils;
	}
	
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties = loadProperties();
		Connection connection = DriverManager.getConnection(
				properties.getProperty("jdbc.url"), 
				properties.getProperty("jdbc.username"),
				properties.getProperty("jdbc.password"));
		
		return connection;
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private Properties loadProperties() {
//		this is try with resource 
		Properties properties = new Properties();
		try (InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("application.properties")){
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("exception caught");
		}
		
		return properties;
	}
}
