<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>

</style>
<!--  meta charset="ISO-8859-1"-->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spoty Shoes</title>
</head>
<body>

<h1>Hello Welcome to Sporty Shoes</h1>
<h3>Please login to continue</h3>

	<h2>Customer log in</h2>
	<form action = "CLogin" method = "post"> 
		E-mail <input type = "text" name = "c_email"/>
		Password <input type = "password" name = "c_pwd"/>			
		<input type = "submit" value = "Login"/> 	
	</form>	
	
		
	<span style ="color:red"> ${errorMessage}</span><br/>



	<h3>If you want to register, please click the register button below </h3>	 
	<form action = "Register" method = "post"> 
		<input type = "submit" value = "Registration"/>	
	</form>
		
	<h3>For admin login, please press below</h3>
	<form action = "Admin" method = "post"> 		
	 	ID <input type = "text" name = "a_id"/>
		Password <input type = "password" name = "a_pwd"/>			
		<input type = "submit"/> 		
	</form>			
	
	
	<span style ="color:red"> ${errorMessage1}</span><br/>
	
	
			
	 <h3>To look at Directors Please click below</h3>
	<a href="DirectorsPath">List of Directors</a>
</body>
</html>





