<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
	<title>Department Information Page</title>

</head>
<body>
<h1>
	Add Department Information
</h1>

<form:form action="http://localhost:8080/RegistrationLogin/dept/save" modelAttribute="deptbean" method="post">

<table>
	<c:if test="${!empty deptbean.deptName}">
					<tr>
						<td>
							<form:label path="deptId">
								<spring:message text="Dept Id :"/>
							</form:label>
						</td>
						<td>
							<form:input path="deptId" readonly="true" size="8"  disabled="true" />
							<form:hidden path="deptId" />
						</td> 
					</tr>
	</c:if>
	
	
	<tr>
		<td>
			<form:label path="deptName">
				<spring:message text="Dept Name : "/>
			</form:label>
		</td>
		<td>
			<form:input path="deptName" />
		</td> 
	</tr>
	

	<tr>
		<td>
			<form:label path="deptCode">
				<spring:message text="Dept Code : "/>
			</form:label>
		</td>
		<td>
			<form:input path="deptCode" />
		</td> 
	</tr>


	
	<tr>
		<td>
			<form:label path="specialities">
				<spring:message text="Dept specialities :"/>
			</form:label>
		</td>
		<td>
			<form:input path="specialities" />
		</td>
	</tr>
	
 <tr>
		<td>
			<form:label path="noOfLabs">
				<spring:message text="NoOfLab"/>
			</form:label>
		</td>
		<td>
			<form:input path="noOfLabs" />
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty deptbean.deptName}">
				<input type="submit"
					value="<spring:message text="Edit Dept"/>" />
			</c:if>
			<c:if test="${empty deptbean.deptName}">
				<input type="submit"
					value="<spring:message text="Add Dept"/>" />
			</c:if>
		</td>
	</tr>
	
</table>	
</form:form>

<br>
<h3>Dept List</h3>
<c:if test="${!empty listDepts}">

	<table class="tg">
	<tr>
		<th width="80">Dept ID</th>
		<th width="120">Dept Name</th>
		<th width="120">Dept Price</th>
		<th width="120">Dept isActive</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>

	<c:forEach items="${listDepts}" var="dept">
		<tr>
			<td>${dept.deptId}</td>
			<td>${dept.deptName}</td>
			<td>${dept.deptCode}</td>
			<td>${dept.specialities}</td>
			<td>${dept.noOfLabs}</td>
			<td><a href="<c:url value='/dept/edit/${dept.deptId}' />" >Edit</a></td>
			<td><a href="<c:url value='/dept/remove/${dept.deptId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
