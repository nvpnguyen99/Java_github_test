<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Category</h1>
	<spring:form action="doAddCategory" method="post"
		modelAttribute="category">
		Category name:<spring:input path="name" />
		<!-- <input type="text" name="name"/> -->
		<br />
		<input type="submit" value="Submit">
	</spring:form>
</body>
</html>