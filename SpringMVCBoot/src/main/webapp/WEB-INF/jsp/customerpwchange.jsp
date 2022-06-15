<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<p>Would you like to change password?</p>	
<form action="custpwchange1" method="POST">
		e-mail: <br>
	<input type="text" name="email"/>
		<br>
		new password:<br>
	<input type="password" name="cpwd"/>
		<br>
	<input type="submit" value ="submit"/>
		<br>		
</form>


<span style ="color:red"> ${errorMessage2}</span><br/>
<span style ="color:blue"> ${success}</span><br/>	
 
</body>
</html>