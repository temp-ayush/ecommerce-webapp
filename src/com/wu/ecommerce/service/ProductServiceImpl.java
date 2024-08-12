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
import com.wu.ecommerce.repo.ProductRepository;
import com.wu.ecommerce.repo.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository = ProductRepositoryImpl.getInstance();
	
	private ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static ProductService productService;
	
	public static ProductService getInstance() {
		if(productService == null) {
			productService = new ProductServiceImpl();
		}
		
		return productService;
	}
	@Override
	public Product addProduct(Product product) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return productRepository.addProduct(product);
		
	}

	@Override
	public Product getProductByProductId(String id) throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		return productRepository.getProductByProductId(id);
	}

	@Override
	public List<Product> getProducts() throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		return productRepository.getProducts();
	}

	@Override
	public List<Product> getAllProductsByCategory(String cat) throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		return productRepository.getAllProductsByCategory(cat);
	}

	@Override
	public String removeProductByProductId(String id) throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		return productRepository.removeProductByProductId(id);
	}

	@Override
	public Product updateProductByProductId(String id, Product product) throws IdNotFoundException, ClassNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		return productRepository.updateProductByProductId(id, product);
	}

}
