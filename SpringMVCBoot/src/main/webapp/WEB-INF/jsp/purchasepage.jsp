<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br style = "line-height:63;">

Please tell us the quantity you would like to order

	<form action = "orderamount" method = "post"> 
		<input type = "text" name ="orderamount1" />
		<input type = "submit" value = "submit"/>		
	</form>	
	
		<span style ="color:green"> ${errorMessage1}</span><br/>
 
</body>



</html>