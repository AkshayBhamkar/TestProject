<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
	<title>Person Page</title>

</head>
<body>
<h1>
	Add a Products
</h1>
R
<form:form action="http://localhost:8080/save" modelAttribute="productbn" method="post">


<table>
	<c:if test="${!empty productbn.productName}">
					<tr>
						<td>
							<form:label path="productId">
								<spring:message text="Product Id :"/>
							</form:label>
						</td>
						<td>
							<form:input path="productId" readonly="true" size="8"  disabled="true" />
							<form:hidden path="productId" />
						</td> 
					</tr>
	</c:if>
	
	
	<tr>
		<td>
			<form:label path="productName">
				<spring:message text="Product Name : "/>
			</form:label>
		</td>
		<td>
			<form:input path="productName" />
		</td> 
	</tr>
	
	
	<tr>
		<td>
			<form:label path="productPrice">
				<spring:message text="Product Price :"/>
			</form:label>
		</td>
		<td>
			<form:input path="productPrice" />
		</td>
	</tr>
	
 <tr>
		<td>
			<form:label path="active">
				<spring:message text="Is Active :"/>
			</form:label>
		</td>
		<td>
			<form:input path="active" />
		</td>
	</tr>
	
	
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty productbn.productName}">
				<input type="submit"
					value="<spring:message text="Edit Product"/>" />
			</c:if>
			<c:if test="${empty productbn.productName}">
				<input type="submit"
					value="<spring:message text="Add Product"/>" />
			</c:if>
		</td>
	</tr>
	
</table>	
</form:form>

<br>
<h3>Product List</h3>
<c:if test="${!empty listProducts}">

	<table class="tg">
	<tr>
		<th width="80">Product ID</th>
		<th width="120">Product Name</th>
		<th width="120">Product Price</th>
		<th width="120">Product isActive</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>

	<c:forEach items="${listProducts}" var="product">
		<tr>
			<td>${product.productId}</td>
			<td>${product.productName}</td>
			<td>${product.productPrice}</td>
			<td>${product.active}</td>
			<td><a href="<c:url value='/edit/${product.productId}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${product.productId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
