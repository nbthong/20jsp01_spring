<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administration</title>
</head>
<body>

<h1>ADMINSTRATION</h1>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Author</th>
			<th>Publisher</th>
			<th>Type</th>
			<th>Language</th>
			<th width="400">Description</th>
			<th>Quantity</th>

			<th>Action</th>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.author}</td>
				<td>${book.publisher}</td>
				<td>${book.type}</td>
				<td>${book.language}</td>
				<td>${book.description}</td>
				<td>${book.quantity}</td>
				

				
				<td>
					<a href="updateBook?id=${book.id}">Update</a>
					<a href="deleteBook?id=${book.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="${pageContext.request.contextPath}/book/add">Add Book</a>
	<a href="${pageContext.request.contextPath}/book/addForm">Add Book Form</a>
</body>
</html>