package com.wu.ecommerce.dto;

import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

//@Data
@Getter
//@Setter
@ToString
@EqualsAndHashCode
//@AllArgsConstructor
@NoArgsConstructor
public class Product
//implements Comparable<Product>
{
	private String productId;

//	private Object obj = new Object();
//	System.out.println(obj.toString());

//	public int compareTo(Product o) {
//		return this.productId.compareTo(o.productId);
//	}

	public Product(String productId, String productName, float price, String categoryName)
			throws InvalidIdException, InvalidPriceException {
		super();
		this.setProductId(productId);
		this.productName = productName;
		this.setPrice(price);
		this.categoryName = categoryName;
	}

	public void setProductId(String productId) throws InvalidIdException {
		if (productId == null || productId.equals("") || productId.length() < 3) {
			// raise an exception
			throw new InvalidIdException("id is invalid");
		}

		this.productId = productId;
	}

	@Setter
	private String productName;
//	@Exclude
	private float price;

	public void setPrice(float price) throws InvalidPriceException {
		if (price < 0f) {
			throw new InvalidPriceException("price should be something atleast man!");
		}
		this.price = price;
	}

	@Setter
	private String categoryName;

}
