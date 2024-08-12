package com.wu.ecommerce.exception;

public class InvalidIdException extends Exception {
	
	public InvalidIdException(String msg) {
		super(msg); // calling the constructor of Exception (parent class) 
	}
	
	@Override
	public String toString() {
		return super.getMessage();
	}
}
