<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center">Welcome to Admin Page</h1>	

<p>To see customer's list please click below.</p>
<form action="CustomerList" method="POST">
	<input type="submit" value ="CustomerList"/>			
</form>
	
<p>Would you like to Look for a Customer by their name?: <a href="customer_lookup">Customer lookup</a></p>
	
<br>
<p>To see product list please click below.</p>	
<form action="BrandList" method="POST">
	<input type="submit" value ="Product List"/>			
</form>


<p>To add product please click below.</p>	
<form action="addproduct" method="GET">
	<input type="submit" value ="Add Product"/>			
</form>




<p>To see purchase list please click below.</p>	
<form action="purchaselist" method="POST">
	<input type="submit" value ="Purchase List"/>			
</form>

<p>Would you like to Look for purchase list by date?: <a href="date_lookup">Date lookup</a></p>
<p>Would you like to Look for purchase list by Customer id?: <a href="customerid_lookup">Look up by Customer's id</a></p>

	
	
<br>	

<p>Would you like to change password?</p>	
<form action="adminpwchange" method="POST">
		Id: <br>
	<input type="text" name="acid"/>
		<br>
		new password:<br>
	<input type="text" name="acpwd"/>
		<br>
	<input type="submit" value ="submit"/>
		<br>		
</form>


<span style ="color:red"> ${errorMessage2}</span><br/>
<span style ="color:blue"> ${success}</span><br/>		
		
		

	
	
	
</body>
</html>