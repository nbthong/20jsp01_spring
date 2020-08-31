<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert book</title>
</head>
<body>

<h1>ADD NEW BOOK</h1>

<form:form modelAttribute="book" action="${pageContext.request.contextPath}/book/addForm" method="post">

	<form:input path="name" placeholder="Book Name"/> <br>
	<form:input path="author" placeholder="Author"/> <br>
	<form:input path="publisher" placeholder="Publisher"/> <br>
	<form:input path="type" placeholder="Type"/> <br>
	<form:input path="language"  placeholder="Language"/> <br>
	<form:input path="description" placeholder="Description"/> <br>
	<form:input path="quantity" placeholder="Quantity"/> <br>
	
	<input type="submit" value="Add">
</form:form>
</body>
</html>