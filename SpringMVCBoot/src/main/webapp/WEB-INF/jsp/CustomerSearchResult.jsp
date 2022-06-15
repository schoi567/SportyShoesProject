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



		<h2 align = center>Following are the information about selected customers</h2>
<table border="1", align = center>
<tr>
<td>Customer id</td>
<td>full name</td>
<td>e-mail</td>
<td>credit card type</td>
<td>credit card number</td>
</tr>
 

<c:set var = "customer_name" value = "${customername}" />

<%
try{String name = (String)pageContext.getAttribute("customer_name");
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvcboottest", "root", "12345678");
statement=connection.createStatement();
String sql = "SELECT * FROM customers where fullname='"+name+"'"; 


resultSet = statement.executeQuery(sql);

while(resultSet.next()) {
%>
<tr>
<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("fullname") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("credit_card_number")%></td>
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