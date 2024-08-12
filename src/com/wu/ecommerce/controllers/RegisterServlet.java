package com.wu.ecommerce.controllers;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;
 
 
/**
* Servlet implementation class RegisterServlet
*/
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getInstance();
	private ProductService productService = ProductServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/registerPage.jsp");
	dispatcher.forward(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		User user=null;
		String firstName=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		String userId=request.getParameter("userid");
		System.out.println(firstName + " " + lastName + " " + address + " " + contact + " " + userId);
//		String orderId=request.getParameter("orderId");
		if(firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || contact.isEmpty() || userId.isEmpty()) {
		}
		else {

			try {
				user=userService.addUser(new User(userId, firstName, lastName, address, contact));
				if(user != null) {
//					common data collection in a context
					List<Product> productList = productService.getProducts();
					
					ServletContext servletContext = request.getServletContext();
					servletContext.setAttribute("productList", productList);
					
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("user", user);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println(user);
	}
 
}