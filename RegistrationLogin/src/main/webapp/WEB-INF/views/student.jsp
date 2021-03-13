<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
	<title>Student Information Page</title>

</head>
<body>
<h1>
	Add Student Information
</h1>

<form:form action="http://localhost:8080/RegistrationLogin/student/save" modelAttribute="studbean" method="POST"
enctype = "multipart/form-data">
<table>
	<c:if test="${!empty studbean.studName}">
					<tr>
						<td>
							<form:label path="studId">
								<spring:message text="Student Id :"/>
							</form:label>
						</td>
						<td>
							<form:input path="studId" readonly="true" size="8"  disabled="true" />
							<form:hidden path="studId" />
						</td> 
					</tr>
	</c:if>
	
	
	<tr>
		<td>
			<form:label path="studName">
				<spring:message text="Student Name : "/>
			</form:label>
		</td>
		<td>
			<form:input path="studName" />
		</td> 
	</tr>
	
	
	<tr>
		<td>
			<form:label path="studAge">
				<spring:message text="Student Age :"/>
			</form:label>
		</td>
		<td>
			<form:input path="studAge" />
		</td>
	</tr>
	
	
	<tr>
		<td>
		
		
			<form:label path="gender">
				<spring:message text="Student Gender :"/>
			</form:label>
		</td>
		<td>
			<form:radiobutton path="gender" value="M" />Male 
			<form:radiobutton path="gender" value="F" />Female
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="Student email :"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td>
	</tr>
	
	
	<tr>
		<td>
			<form:label path="address">
				<spring:message text="Student address :"/>
			</form:label>
		</td>
		<td>
			<form:input path="address" />
		</td>
	</tr>
 
 <tr>
		<td>
			<form:label path="contactNo">
				<spring:message text="Contact No :"/>
			</form:label>
		</td>
		<td>
			<form:input path="contactNo" />
		</td>
	</tr>


<tr>
		<td>
			<form:label path="studentPhoto">
				<spring:message text="Upload Photo"/>
			</form:label>
		</td>
		<td>
			 <td><input type="file" name="studentPhoto" /></td>
		</td>
	</tr>


<tr>
		<td>
			<form:label path="listOfSubjs">
				<spring:message text="List Of Subjects "/>
			</form:label>
		</td>
		<td>
			<c:forEach items="${subjects}" var="subj"> 
					<form:checkbox value="${subj.subjId}" path="listOfSubjs"/>${subj.subjName}<br> 
			</c:forEach> 
		</td>
	</tr>
	
	
<tr>
		<td>
			<form:label path="deptName">
				<spring:message text="Select Department"/>
			</form:label>
		</td>
		<td>
			<form:select path="deptName" items="${depts}" />
		</td>
	</tr>


	<tr>
		<td>
			<form:label path="listOfHobbies">
				<spring:message text="Select Multiple Hobbies"/>
			</form:label>
		</td>
		<td>
			<form:select path="listOfHobbies" items="${hobbies}" multiple="true" />
		</td>
	</tr>


	<tr>
		<td colspan="2">
			<c:if test="${!empty studbean.studName}">
				<input type="submit"
					value="<spring:message text="Edit Student"/>" />
			</c:if>
			<c:if test="${empty studbean.studName}">
				<input type="submit"
					value="<spring:message text="Add Student"/>" />
			</c:if>
		</td>
	</tr>
	
	
	
	
</table>	
</form:form>

<br>
<h3>Student List</h3>
<c:if test="${!empty listOfstuds}">

	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">NAME</th>
		<th width="120">AGE</th>
		<th width="120">EMAIL</th>
		<th width="120">ADDRESS</th>
		<th width="120">EMAIL</th>
		<th width="60">ACTION</th>
	</tr>

	<c:forEach items="${studlist}" var="stud">
		<tr>
			<td>${stud.studId}</td>
			<td>${stud.studName}</td>
			<td>${stud.studAge}</td>
			<td>${stud.studEmail}</td>
			<td>${stud.studAddress}</td>
			<td><a href="<c:url value='student/edit/${stud.studId}' />" >Edit</a> | &nbsp;&nbsp;&nbsp;&nbsp; <a href="<c:url value='student/remove/${stud.studId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
