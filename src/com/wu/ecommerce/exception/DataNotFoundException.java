package com.wu.ecommerce.exception;

public class DataNotFoundException extends Exception {

	public DataNotFoundException(String msg) {
		super(msg); // calling the constructor of Exception (parent class) 
	}
	
	@Override
	public String toString() {
		return super.getMessage();
	}
}
