<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>    
<%@page import="java.sql.DriverManager"%>
<%@page import="com.test.example.entity.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--  page errorPage="error.jsp"  -->
<!-- Upper is important for importing and making sense of file as prefix c  -->
<!-- taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" -->


 
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



		<h1 align = center>Following are the list of all information about Purchases with Customer's id: ${customersearchid}</h1>
<table border="1", align = center>
<tr>
<td>purchase id</td>
<td>purchase date</td>
<td>purchase quantity</td>
<td>purchase amount</td>
<td>customers id</td>
<td>fullname</td>
<td>customers email</td>
<td>products id</td>
<td>products brand</td>
<td>product name</td>
<td>unit price</td>
</tr>
 

<c:set var = "customer_id" value = "${customersearchid}" />

<%
try{String CID = (String)pageContext.getAttribute("customer_id");
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvcboottest", "root", "12345678");
statement=connection.createStatement();
String sql = "SELECT * FROM purchase_customers_product_rev where customers_id=" + CID; 


resultSet = statement.executeQuery(sql);

while(resultSet.next()) {
%>
<tr>
<td><%=resultSet.getString("purchase_id") %></td>
<td><%=resultSet.getString("purchase_date") %></td>
<td><%=resultSet.getString("purchase_quantity") %></td>
<td><%="$" + resultSet.getString("purchase_amount") %></td>
<td><%=resultSet.getString("customers_id") %></td>
<td><%=resultSet.getString("fullname") %></td>
<td><%=resultSet.getString("customers_email") %></td>
<td><%=resultSet.getString("productsid") %></td>
<td><%=resultSet.getString("products_brand") %></td>
<td><%=resultSet.getString("product_name") %></td>
<td><%="$" + resultSet.getString("unit_price") %></td>
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