package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;

public interface ProductService {
	
	
	public Product addProduct(Product product) throws ClassNotFoundException, SQLException;
	public Product getProductByProductId (String id) throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	public List<Product> getProducts() throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	public List<Product> getAllProductsByCategory(String cat) throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	
	public String removeProductByProductId(String id) throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	public Product updateProductByProductId (String id, Product product) throws IdNotFoundException, ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	
	
	default void display() {
		System.out.println("hello from Product Service");
	}

}
