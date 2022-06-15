<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>    

<%
//String id = request.getParameter("userid");
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
<title>Customer List</title>
</head>
<body>
		<h1 align = center>Following are the list of all information about Products </h1>
<table border="1", align = center>
<tr>
<td>Customer id</td>
<td>Customer name</td>
<td>Customer e-mail</td>
<td>Credit Card Number</td>
<td>Credit Card Type</td>


</tr>


<%
try{
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvcboottest", "root", "12345678");
statement=connection.createStatement();
String sql = "SELECT * FROM customers";
resultSet = statement.executeQuery(sql);

while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("fullname") %></td>
<td><%=resultSet.getString("credit_card_number") %></td>
<td><%=resultSet.getString("credit_card_type") %></td>

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

</table> 




	
	
</body>
</html>