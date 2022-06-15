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
String sql = "SELECT * FROM products where productsid=1";
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
 

		
<p style = "position:absolute; left:80px; font-size:17px; bottom: 250px;">
<b>Description:</b> Air Jordan is a line of basketball shoes, athletic, casual, and style clothing produced by American corporation Nike. <br/>
The first Air Jordan shoe was produced for Hall of Fame former basketball player Michael Jordan during his time with the Chicago Bulls <br/>in late 1984, 
and released to the public on April 1, 1985.
<br>
<br>
@ from Wikipedia

</p>		



 
		
		
</body>
</html>