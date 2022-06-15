<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<p><b>Please type customerid number and password for verification. </b><p>


	<form action = "customerid1" method = "POST"> 
		Customerid <input type = "text" name ="customerid" />
		Password <input type = "password" name = "password_verify"/>			
		<input type = "submit" value = "submit"/>	
		
			
	</form>	
	
		<span style ="color:red"> ${errorMessage}</span><br/>
 		<span style ="color:red"> ${errorMessage1}</span><br/>
</body>



</html>