package com.wu.ecommerce.exception;

public class InvalidPriceException extends Exception {
	public InvalidPriceException(String msg) {
		super(msg); // calling the constructor of Exception (parent class) 
	}
	
	@Override
	public String toString() {
		return super.getMessage();
	}
}
