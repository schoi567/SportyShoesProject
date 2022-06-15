<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Please Fill out followings</p> 

<form action="addproduct1" method="GET">
	 <label for="Brand">Choose a Brand:</label>
	
	<select id="Brand" name="brand">
		 <option value="Nike">Nike</option>
    <option value="Addidas">Addidas</option>
    <option value="Puma">Puma</option> 
 	</select>

	Product Name: <input type="text" name ="productname"/>	
	
	<label for="Color">Choose a Brand:</label>
	<select id="Color" name="color">
		<option value="Red">Red</option>
    	<option value="Blue">Blue</option>
    	<option value="Yellow ">Yellow </option> 
  	</select>
	
	Size: <input type="number" name ="size"/>		
	
	Price: <input type="number" name ="price"/>				

	
	<input type="submit" value ="submit"/>	

<br>
<span style ="color:red"> ${errorMessage}</span><br/>


</form>

</body>
</html>