 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page isELIgnored="false"%>
<html>
<head>
<title>Flowers</title>
<style type="text/css">
body {
	background: #03a9f455;
}
table {
	border-collapse: collapse;
	width: 80%;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	background: rgba(255, 255, 255, 0.2);
}

th, td {
	padding: 5px;
	text-align: center;
	border-bottom: 1px solid #aaa;
	font-size: 18px;
}

th {
	text-transform: uppercase;
	background-color: #03a9f455;
	color: white;
	height: 50px;
}	
h2 {
	margin-top: 1px;
	text-align: center;
	font-family: cursive;
	color: #333;
}
</style>
</head>
<body>
	<h2>Fetch image from database using Spring MVC</h2>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
		</tr>
		<c:forEach var="flower" items="${listFlower}">
			<tr>
				<td style="height:100px;width:100px">${flower.id}</td>
				<td>${flower.name}</td>
				<td style="height:100px;width:100px"><img width="100%" height="100%"
					src="getFlowerPhoto/<c:out value='${flower.id}'/>"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
