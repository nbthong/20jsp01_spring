<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/hello" method="get" >
	<input type="text" name="name" placeholder="NAME"> <br>
	<input type="text" name="age" placeholder="AGE"> <br>
	<input type="submit" value="Add">
</form>
	<h1>Hello, ${msg}</h1>
	<h2>Age: ${age}</h2>
</body>
</html>