<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>        
<%
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306";
String database = "springmvcboottest";
String userid = "root";
String password = "12345678";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p style = "position:relative; left:80px; font-size:20px;"> Below are shoes available in our store. </p>
<table border="1", style = "position:relative; left:80px; font-size:15px;">
	<tr>
		<td>id</td>
		<td>Brand</td>
		<td>Product Name</td>
		<td>Color</td>
		<td>Size</td>
		<td>Price</td>
	</tr>

	
<%
try{
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvcboottest", "root", "12345678");
statement=connection.createStatement();
String sql = "SELECT * FROM products";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<tr>
	<td><%=resultSet.getString("productsid") %></td>
	<td><%=resultSet.getString("brand") %></td>
	<td><%=resultSet.getString("productname") %></td>
	<td><%=resultSet.getString("color") %></td>
	<td><%=resultSet.getString("size") +" inches" %></td>
	<td><%= "$" +resultSet.getString("price") %></td>
		<td>
	<form action = "<%="deleteproduct"+resultSet.getString("productsid")%>" method = "GET"> 
		<input type = "submit" value = "Delete This Product"/>	
	</form>		
	</td> 
</tr>


<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>


</body>
</html>





