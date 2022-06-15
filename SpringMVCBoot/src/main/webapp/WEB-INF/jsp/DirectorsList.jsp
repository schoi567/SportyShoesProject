<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
<head>
	<title> List Directors </title>
	<style>
	html, body  {
	margin-left: 15px; margin-right: 15px;
	padding: 0px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}

table  {
	border-collapse: collapse;
	border-bottom: 1px solid black;
	font-family: Tahoma,Verdana,Segoe,sans-serif;
	width: 72%;
}

th {
	border-bottom: 1px solid black;
	background: none repeat scroll 0 0 #09c332;
	padding: 10px;
	color: #FFFFFF;
}

tr {
	border-top: 1px solid black;
	text-align: center;
}

tr:nth-child(even) {background: #FFFFFF;}
tr:nth-child(odd) {background: #BBBBBB;}


#wrapper {width: 100%; margin-top: 0px;}
#header {width: 70%; background: #09c332;margin-top: 0px; padding: 15px 0px 15px 15px;}
#header h2 {width: 100%; margin: auto; color: #FFFFFF;}
#container {width: 100%; margin: auto;}
#container h3 {color: #000;}
#container #content {margin-top: 20px;}

.add-button {
	border: 1px solid #666;
	border-radius: 5px;
	padding: 4px;
	font-size: 12px;
	font-weight: bold;
	width: 120px;
	padding: 5px 10px;
	
	margin-top: 15px;
	background: #cccccc;
}
h1{text-align: center;}	
	
	</style>

	
</head>
<body>

<h1>We will always strive to meet our customer's needs. </h1>


<div align="center" id="wrapper">
	<div align="center" id="header">
		<h2>  List of Directors </h2>
	</div>
</div>


<div id="container">

	
<br> 
		
		<table align="center">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Position</th>
				<th>Term Renewal</th>

			</tr>
			
	<c:forEach var="tempDirectors" items="${Directors}"> 

		<tr>
				<td>${tempDirectors.id}</td>
				<td>${tempDirectors.name}</td>
				<td>${tempDirectors.position}</td>
				<td><fmt:formatDate type="date" value="${tempDirectors.termrenewal}"/></td>
				 
		<tr>
</c:forEach>
</table>


	 








</body>
</html>