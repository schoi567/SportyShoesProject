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
	</tr>

	
<%
try{
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvcboottest", "root", "12345678");
statement=connection.createStatement();
String sql = "SELECT * FROM products where productsid=2";
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
 
</tr>
		 

<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
 

		
<p style = "position:absolute; left:80px; font-size:17px; bottom: 95px;">
<b>Description:</b> The Adidas Ultraboost is a model of shoe that was created by Adidas AG. <br/>
The shoe was created in January 2015, and was revealed and became available to the public in late February 2015. <br/>
Adidas is on its seventh iteration of the shoe, with the Ultraboost 22 being released in late 2021 and early 2022.  <br/>
The design of the Ultraboost came after a statement made by Matthias Amm, adidas' Running department director.  <br/>
"We knew we had to create an upper that could enhance the underfoot feeling to create a holistic, exciting comfort experience.  <br/>
Our Futures team started to work on enhancing this concept with more Boost, a better transition, and an amazing, superior fit on the upper," he stated.  <br/>
Although there was an issue with production of BOOST, with adidas only rumored to have one factory optimized for the production, they soon switched over a  <br/>
multitude of factories to keep up with the demand. With adidas working with NASA to develop an outsole that would return the most energy and become the most optimal for running, <br/> 
they came up with the Torsion System outsole, adorned with Continental-branded rubber.
Eventually, the Ultraboost was created by the Futures team in January 2015, with it being available to the public in February 2015.
<br>
<br>
@ from Wikipedia
</p>		



 
		
		
</body>
</html>