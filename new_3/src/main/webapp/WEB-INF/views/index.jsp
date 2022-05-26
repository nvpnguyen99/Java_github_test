<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Index page</h1>
	<a href="addBook">Add Book</a>
	<br/>
	<a href="addCategory">Add Category</a>
	
	<form action="search" method="get">
	<input type ="text" name = "keyword" placeholder="name,author,isbn"/>
	<input type ="submit" value = "Search"/>
	</form>
	<table border ="1">
	<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Author</th>
	<th>ISBN</th>
	<th>Price</th>
	<th>Publish Date</th>
	<th>Category</th>
	</tr>
	
	<c:forEach items="${bookList}" var="item">
	<tr>
	<td> ${item.id} </td>
	<td> ${item.name} </td>
	<td> ${item.author} </td>
	<td> ${item.bookDetails.isbn} </td>
	<td> ${item.bookDetails.price} </td>
	<td> ${item.bookDetails.publishDate} </td>
	<td> ${item.category.name} </td>
	<td> <a href="updateBook?id=${item.id}">Update</a> <a href="dodeleteBook?id=${item.id}">Delete</a> </td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>