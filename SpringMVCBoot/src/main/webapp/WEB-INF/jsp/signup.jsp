<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<div class="container text-center">
		<h1>Welcome to Spoty Shoes</h1>
	<br>
	
<form method="post" action="signup1">
		E-mail: <br>
	<input type="text" name="email">
		<br>
		Password:<br>
	<input type="password" name="password">
		<br>
		Full Name:<br>				
	<input type="text" name="fullname">		
		<br>
		
	Credit Card Number:<br>				
	<input type="text" name="CCnumber">		
		<br>	

	Credit Card Type:<br>				
	<input type="text" name="CCType">		
		<br>		
		
		
 	

<input type="submit" value="submit">
		<br>		
</form>
		<span style ="color:red"> ${errorMessage3}</span><br/>
		<span style ="color:red"> ${errorMessage2}</span><br/>		
		
	</div>
	
	
	
	
</body>
</html>