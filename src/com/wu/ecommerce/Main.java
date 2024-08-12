package com.wu.ecommerce;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
//		ProductService productService = ProductServiceImpl.getInstance();
//		
//		for (int i=0; i<25; i++) {
//			try {
//				try {
//					productService.addProduct(new Product("A", "Tanuj", 0, "Finance"));
//				} catch (InvalidPriceException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (InvalidIdException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
////		Optional<Product[]> prod = productService.getProducts();
////		
////		prod.ifPresent(products -> {
////			for(Product product : products) {
////				System.out.println(product);
////			}
////		});
////		
////		Optional<Product> prod1 = productService.getProductByProductId("A");
////		System.out.println(prod1.toString());
//		
//		
//		Optional<Product[]> prod2 = productService.getAllProductsByCategory("Finance");
//		
////		prod2.ifPresent(products -> {
////			for(Product product : products) {
////				System.out.println(product);
////			}
////		});
////		Product[] temp = prod2.get();
////		for(Product p: temp) {
////			if(p!=null)
////			System.out.println(p.toString());
////		}
//		
//		
//		Product samsung;
//		try {
//			try {
//				samsung = new Product("B", "Anish", 500f, "Bank");
//				Product temp3 = productService.updateProductByProductId("A", samsung);
//				System.out.println(temp3.getProductName());
//			} catch (InvalidPriceException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		} catch (InvalidIdException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	
//		
//		
//		
//		Optional<Product[]> prod1 = productService.getProducts();
//		Product[] t = prod1.get();
//		for(Product p: t) {
//			if(p!=null)
//			System.out.println(p.toString());
//		}
//		
//		System.out.println(productService.removeProductByProductId("A"));
//		
//		Optional<Product[]> prod5 = productService.getProducts();
//		Product[] t2 = prod5.get();
//		for(Product p: t2) {
//			if(p!=null)
//			System.out.println(p.toString());
//		}
//		
//		int b[] =  new int[10];
//		int a = 0;
//		try {
////			a = 10/0;
////			this is array out of boundException
//			b[11] = 0;
//			System.out.println("Inside try");
//			
//		} catch (ArithmeticException e) {
//			a = 10/2;
//			System.out.println("INside catch");
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(e);
//			System.out.println("inside array catch");
//		}
////		this is parent of all exceptions so keep it in last or above one will become unreachable
//		catch(Exception e) {
//			System.out.println("Exception occured" + e);
//		}
//		catch(Throwable e) {
//			System.out.println("in throwable");
//		}
////		this will generate error , Object is parent class but still it is till Throwable only.
////		catch(Object e) {
////			System.out.println("hello ");
////		}
//		finally {
//			a = 10/5;
//			System.out.println("Helllo");
//		}
//		System.out.println(a);
//		
//		
//		try {
//			Product pr = new Product("Abcd", "nice", 60.0f, "finance");
//			System.out.println("Here inside try");
//			System.out.println(pr.toString());
//			System.out.println(pr.hashCode());
//			System.out.println(Integer.toHexString(pr.hashCode()));
//		} 
//		 catch(InvalidPriceException e) {
//				System.out.println("Price exception");
//			}catch(InvalidIdException e) {
//			System.out.println("Catch pakad liya bc");
//		}
		
		
//		OrderService orderService = OrderServiceImpl.getInstance();
//		Order x = new Order("123", "First", "Last", "Pune", "908798453");
//		orderService.addOrder(x);
//		System.out.println(orderService.getOrderByOrderId("123").toString());
//		
//		
//		ProductService productService = ProductServiceImpl.getInstance();
//		try {
//			productService.addProduct(new Product("ABCD", "Tanuj", 0, "Finance"));
//			List<Product> t = productService.getAllProductsByCategory("Finance");
//			for(Product p : t) {
//				System.out.println(p.toString());
//			}
//			System.out.println(productService.getProductByProductId("ABCD"));
//		} catch (InvalidIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidPriceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
		ProductService productService = ProductServiceImpl.getInstance();
		UserService userService = UserServiceImpl.getInstance();
		System.out.println("before  ");
		Scanner sc = new Scanner(System.in);
		int choice = 0 ;
		while(true) {
			System.out.println("1 - Add Product");
			System.out.println("2 - Get Product by id");
			System.out.println("3 - Get all products");
			System.out.println("4 - Get products by category");
			System.out.println("5 - Remove Product by id");
			System.out.println("6 - Update product by id");
			System.out.println("7 - Add Product");
			System.out.println("here ");
			System.out.println("8 - Get Product by id");
			System.out.println("9 - Get all products");
			System.out.println("10 - Get products by category");
			System.out.println("11 - Remove Product by id");
			System.out.println("12 - Update product by id");
			System.out.println("13 - Exit");
			System.out.println("enter your choice");
			choice = sc.nextInt();
			
			
			switch(choice) {
			case 1: 
				Product pr = new Product("ABCD", "Jai", 600f, "finance");
				Product pr11 = new Product("XXXX", "Jai", 600f, "finance");
				Product pr22= new Product("CDAB", "Jai", 600f, "finance");
				Product pr33 = new Product("CDBA", "Jai", 600f, "finance");
				Product pr44= new Product("AAAA", "Jai", 600f, "finance");
				productService.addProduct(pr);
				productService.addProduct(pr11);
				productService.addProduct(pr22);
				productService.addProduct(pr33);
				productService.addProduct(pr44);
				break;
			
			case 2:
				String id;
				System.out.println("Enter id to search: ");
				id = sc.next();
				Product pr2 = productService.getProductByProductId(id);
				System.out.println(pr2);
				break;
				
			case 3:
				List<Product> pr3 = productService.getProducts();
				for(Product p: pr3) {
					System.out.println(p.toString());
				}
				break;
				
			case 4:
				System.out.println("Enter the category to search: ");
				String cat = sc.next();
				List<Product> pr4 = productService.getAllProductsByCategory(cat);
				for(Product p: pr4) {
					System.out.println(p.toString());
				}
				break;
				
			case 5:
				String id5;
				System.out.println("Enter id to remove: ");
				id5 = sc.next();
				String pr5 = productService.removeProductByProductId(id5);
				System.out.println(pr5);
				break;
				
			case 6:
				String id6;
				System.out.println("Enter id to update: ");
				id6 = sc.next();
				System.out.println("product is: " + productService.getProductByProductId(id6).toString());
				System.out.println("Product id : ");
				String pid = sc.next();
				System.out.println("Product Name :");
				String pname = sc.next();
				System.out.println("Category Name : ");
				String cname = sc.next();
				System.out.println("Price : ");
				Float pp = sc.nextFloat();
				
				Product pr61 = new Product(pid, pname, pp, cname);
				Product pr62 = productService.updateProductByProductId(id6, pr61);
				System.out.println("updated product is : " + pr62);
				break;
				
			case 7:
				User u1 = new User("ABCD", "Ayush", "Dudhani", "Badnapur", "7030775331");
				User u2 = new User("ABCD", "Ayush", "Dudhani", "Badnapur", "7030775331");
				User u3 = new User("ABCD", "Ayush", "Dudhani", "Badnapur", "7030775331");
				User u4 = new User("ABCD", "Ayush", "Dudhani", "Badnapur", "7030775331");
				User u5 = new User("ABCD", "Ayush", "Dudhani", "Badnapur", "7030775331");
				userService.addUser(u1);
				userService.addUser(u2);
				userService.addUser(u3);
				userService.addUser(u4);
				userService.addUser(u5);
				break;
				
			case 8: 
				break;
				
			case 9:
				break;
				
			case 10:
				break;
				
			case 11:
				break;
				
			case 12: 
				break;
				
			case 13:
				System.out.println("u asked to exit ? Exiting...");
				break;
			
				
			default: 
				System.out.println("invalid input");
				break;
			}
		}}catch(Exception e) {
			System.out.println(e);
		}
	}

}
