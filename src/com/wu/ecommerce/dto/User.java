package com.wu.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private String userId;
	private String firstName;
	private String lastName;
	private String address;
	private String contact;	
}
