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
<title>Insert title here</title>
</head>
<body>
		<h1 align = center>Following are the list of all information about Purchases and Purchase History </h1>
<table border="1", align = center>
<tr>
<td>purchase_id</td>
<td>purchase_date</td>
<td>purchase_quantity</td>
<td>purchase_amount</td>
<td>customers_id</td>
<td>fullname</td>
<td>customers_email</td>
<td>productsid</td>
<td>products_brand</td>
<td>product_name</td>
<td>unit_price</td>



</tr>


<%
try{
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvcboottest", "root", "12345678");
statement=connection.createStatement();
String sql = "SELECT * FROM purchase_customers_product_rev";
resultSet = statement.executeQuery(sql);

while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("purchase_id") %></td>
<td><%=resultSet.getString("purchase_date") %></td>
<td><%=resultSet.getString("purchase_quantity") %></td>
<td><%=resultSet.getString("purchase_amount") %></td>
<td><%=resultSet.getString("customers_id") %></td>
<td><%=resultSet.getString("fullname") %></td>
<td><%=resultSet.getString("customers_email") %></td>
<td><%=resultSet.getString("productsid") %></td>
<td><%=resultSet.getString("products_brand") %></td>
<td><%=resultSet.getString("product_name") %></td>
<td><%=resultSet.getString("unit_price") %></td>


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