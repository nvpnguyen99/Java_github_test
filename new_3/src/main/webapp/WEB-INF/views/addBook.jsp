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
	<spring:form action="doAddBook" method="post" modelAttribute="book">
		Name(*):<spring:input path="name" /> <spring:errors path="name"/>
		<!-- <input type="text" name="name"/> -->
		<br />
		Author(*):<spring:input path="author" /> <spring:errors path="author"/>
		<br />
		ISBN(*):<spring:input path="bookDetails.isbn" /> <spring:errors path="bookDetails.isbn"/>
		<br />
		Number of page(*):<spring:input path="bookDetails.numberOfPage" /> <spring:errors path="bookDetails.numberOfPage"/>
		<br />
		Price(*):<spring:input path="bookDetails.price" /> <spring:errors path="bookDetails.price"/>
		<br />
		Publish date(*):<spring:input path="bookDetails.publishDate" type ="date"/> <spring:errors path="bookDetails.publishDate"/>
		<br />
		Category :<spring:select path="category.id" >
		<spring:option value="0">--Select Category--</spring:option>
		<spring:options items="${categoryList}" itemLabel="name" itemValue="id"/> 
		</spring:select>
		<br />
		<input type="submit" value="Submit">
	</spring:form>
</body>
</html>