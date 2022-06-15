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
<h1 style="text-align:center"> Welcome to Spoty Shoes. </h1>
<p style = "position:relative; left:80px; font-size:20px;"> Below are shoes available in our store. </p>
<table border="1", style = "position:relative; left:80px; font-size:15px;">
	<tr>
		<td>id</td>
		<td>Brand</td>
		<td>Product Name</td>
		<td>Color</td>
		<td>Size</td>
		<td>Price</td>
		<td>Purchase</td>
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
	<td><%="$"+resultSet.getString("price") %></td>
	
	<td>
	<form action = "<%="product"+resultSet.getString("productsid")%>" method = "post"> 
		<input type = "submit" value = "Add To Purchase"/>	
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


<div style="position: absolute; bottom: 250px;">
<p>Would you like to cancel purchase?: <a href="cancelpurchase">Cancel Purchase</a></p>

<br><br><br>

</div>	



	<div style="position: absolute; bottom: 150px;">
<!--   <p>Would you like to see descriptions of each products?</p>	
	<form action = "proddetails" method = "GET"> 
		<input type = "submit" value = "View Details"/>	  
	</form>	-->	 
	<p>Would you like to see details of product id 1?: <a href="RyanHaugland">See Details</a></p>
	<p>Would you like to see details of product id 2?: <a href="RyanHaugland1">See Details</a></p>	
	<p>Would you like to see details of product id 3?: <a href="RyanHaugland2">See Details</a></p>			
	</div>	
	
	
	<div style="position: absolute; bottom: 20px;">
		<p>If you would like to change password please click below</p>	
	<form action = "custpwchange" method = "post"> 
		<input type = "submit" value = "Change Password"/>	
	</form>	
	</div>	
	
	
<div style="position: absolute; bottom: 30px;">
<p>Would you like to Logout?: <a href="LogOut">LogOut</a></p>
<br><br><br>
</div>	
	


</body>
</html>