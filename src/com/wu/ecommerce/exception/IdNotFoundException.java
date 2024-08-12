package com.wu.ecommerce.exception;

public class IdNotFoundException extends Exception {

	public IdNotFoundException(String msg) {
		super(msg); // calling the constructor of Exception (parent class) 
	}
	
	@Override
	public String toString() {
		return super.getMessage();
	}
}
