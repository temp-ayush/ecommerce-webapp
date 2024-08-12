package com.wu.ecommerce.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.utils.DBUtils;
import com.wu.ecommerce.utils.IdComparator;

public class ProductRepositoryImpl implements ProductRepository {
//	private contructor
	private ProductRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

//	dummy database (assume)
//	private Product[] products = new Product[10]; 
	private Set<Product> products = new TreeSet<Product>(new IdComparator());
	
//	private TreeSet<Product> products = new TreeSet<Product>(new Comparator<Product>() 
//	{
//		@Override
//		public int compare(Product o1, Product o2) {
//			return o1.getProductName().compareTo(o2.getProductName());
//		}
//	});
	
	
//	better way with lamda functions / arrow functions:
//	private TreeSet<Product> products = new TreeSet<Product>((o1, o2)-> o1.getProductName().compareTo(o2.getProductName()));

	
	

	private static ProductRepository productRepository;

	private static int counter = 0;

	public static ProductRepository getInstance() {
		if (productRepository == null) {
//			create the object;
			productRepository = new ProductRepositoryImpl();
		}
		return productRepository;
	}

	@Override
	public Product addProduct(Product product) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
//		if(counter >= products.length) {
////			increase in size of array
//			Product[] temp = new Product[products.length*2];
//			System.arraycopy(products, 0, temp, 0, products.length);
//			products = temp;
//			
//		} 
////		else {
////			regular addition at the end
//			products[counter++] = product;
////			counter;
////		}
		String insertStatement = "insert into product (productId, productName, CategoryName, Price) values (?, ?, ?, ?)";
		Connection connection = DBUtils.getInstance().getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
		
		preparedStatement.setString(1, product.getProductId());
		preparedStatement.setString(2, product.getProductName());
		preparedStatement.setString(3, product.getCategoryName());
		preparedStatement.setFloat(4, product.getPrice());
		
		int result = preparedStatement.executeUpdate();
		DBUtils.getInstance().closeConnection(connection);
		if(result > 0 ) {
			return product;
		}
		
//		boolean res = products.add(product);
//		if (res) {
////			System.out.println("Added product");
//			return product;
//		}
//		return null;
		return null;

	}

	@Override
	public Product getProductByProductId(String id) throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		
		
//		return products.stream().filter(e -> e.getProductId().equals(id)).findFirst()
//				.orElseThrow(() -> new IdNotFoundException("id not found"));
		
//		------------------------------------------------------------
//		Product holder[] = new Product[1];
//		products.forEach(e-> {
//			if(e.getProductId().equals(id)) {
//				holder[0] = e;
//			}
//		});
//		Product p = holder[0];
//		return Optional.ofNullable(p);
		
//		------------------------------------------------------------
		
		String selectQuery = "select * from product where productid = ?";
		Connection connection = DBUtils.getInstance().getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		preparedStatement.setString(1, id);
		ResultSet res = preparedStatement.executeQuery();
		Product product = null;
		if(res.next()) {
			product = new Product(res.getString(1), res.getString(2), res.getFloat(4), res.getString(3));
		}
		DBUtils.getInstance().closeConnection(connection);
		return product;
		
		
	}

	@Override
	public List<Product> getProducts() throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
//		we need to throw DataNotFoundException
//		list may be empty
//		return Optional.ofNullable(products.stream().collect(Collectors.toList())).filter(l -> !l.isEmpty())
//				.orElseThrow(() -> new DataNotFoundException("There is no data"));
		
		
//		-------------------------------------------------------------------------
		List<Product> products = new ArrayList<Product>();
		String selectQuery = "select * from product";
		
		Connection connection = DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			products.add(new Product(rs.getString(1), rs.getString(2), rs.getFloat(4), rs.getString(3)));
		}
		DBUtils.getInstance().closeConnection(connection);
		return products;

	}

	@Override
	public List<Product> getAllProductsByCategory(String cat) throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
//		toList() method can be used since java 16
//		otherwise we need to use : collect(Collectors.toList());
//		List<Product> temp = products.stream().filter(e -> e.getCategoryName().equals(cat))
//				.collect(Collectors.toList());
//
//		return Optional.ofNullable(temp).filter(l -> !l.isEmpty())
//				.orElseThrow(() -> new DataNotFoundException("data is not found"));
		
//		---------------------------------------------------------------------------
		List<Product> products = new ArrayList<Product>();
		String selectQuery = "select * from product where categoryname = ?";
		Connection connection = DBUtils.getInstance().getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		preparedStatement.setString(1, cat);
		
		ResultSet res = preparedStatement.executeQuery();
		Product product = null;
		
		while(res.next()) {
			products.add(new Product(res.getString(1), res.getString(2), res.getFloat(4), res.getString(3)));
		}
		DBUtils.getInstance().closeConnection(connection);
		
		return products;

//		return null;
	}

	@Override
	public String removeProductByProductId(String id) throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
//		Product product = this.getProductByProductId(id);
//		boolean res = products.remove(product);
//		
//		if (res) {
//			return "success";
//		}
//		return "fail";
		
//		-----------------------------------------------------------------
		
//		---------------------------------------------------------------------------

		String selectQuery = "delete from product where productid = ?";
		Connection connection = DBUtils.getInstance().getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		preparedStatement.setString(1, id);
		
		int res = preparedStatement.executeUpdate();
		DBUtils.getInstance().closeConnection(connection);
		if(res > 0) {
			return "success";
		}
		
		return "fail";
	}

	@Override
	public Product updateProductByProductId(String id, Product product) throws IdNotFoundException, SQLException, ClassNotFoundException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		String selectQuery = "update product set productid = ? , productname = ? , categoryname = ? , price = ? where productid = ? ";
		Connection connection = DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		preparedStatement.setString(1, product.getProductId());
		preparedStatement.setString(2, product.getProductName());
		preparedStatement.setString(3, product.getCategoryName());
		preparedStatement.setFloat(4, product.getPrice());
		preparedStatement.setString(5, id);
		
		int res = preparedStatement.executeUpdate();
		DBUtils.getInstance().closeConnection(connection);
		if(res > 0) {
			return this.getProductByProductId(product.getProductId());
		}
		
		return null;
//		return product;
	}

}
