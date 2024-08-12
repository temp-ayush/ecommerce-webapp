<%@page import="com.wu.ecommerce.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.wu.ecommerce.dto.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to dashboard</h1>
	<h4>this is expression :</h4>
	<%
	User user = (User)session.getAttribute("user");
	out.println(user);
	%>
	
	<h2>Welcome <%= user.getFirstName() %></h2>
	<table>
	<tr>
	<th>Product Id</th>
	<th>Product Name</th>
	<th>Category Name</th>
	<th>Price</th>
	</tr>
	<%
	List<Product> productList = (List<Product>)application.getAttribute("productList");
	out.println(productList);
	
	for(Product pro: productList){ %>
		<tr>
		<td><% out.println(pro.getProductId());%> </td>
		<td><% out.println(pro.getProductName());%> </td>
		<td><% out.println(pro.getCategoryName());%> </td>
		<td><% out.println(pro.getPrice());%> </td>
		</tr>
	<%};
	%>
	</table>
	<a href="logoutServlet">Logout</a>
	
	
</body>
</html>