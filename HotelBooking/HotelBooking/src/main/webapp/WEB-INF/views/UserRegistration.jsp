<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a href="${contextPath}">Go Back</a><br/>
		<h1>New User Registration</h1>
		<form:form action = "${contextPath}/register.htm" commandName="user" method="POST">
		<table>
		<tr>
		<td> User Name:</td>
		<td> <form:input path="username" size="30" required="required" /> 
		<form:errors path="username" />  
		</td>
		</tr>
		<td>First Name:</td>
		<td> <form:input path="first_name" size="30" required="required" /> 
		<form:errors  path="first_name" />  
		</td>
		</tr>
		<tr>
		<td>Last Name:</td>
		<td> <form:input path="last_name" size="30" required="required" /> 
		<form:errors  path="last_name" /> 
		</td>
		</tr>
		<tr>
		<td>Email ID:</td>
		<td> <form:input path="Email_Id" size="30" required="required" />
		<form:errors  path="Email_Id" /> 
		 </td>
		</tr>
		<tr>
		<td>Password:</td>
		<td> <form:password path="password" size="30" required="required" pattern="[_A-z0-9]{1,}$"/> 
		<form:errors  path="password" /> </td>
		</tr>
		<tr>
		<td>Phone Number:</td>
		<td> <form:input path="phone_number" size="30" required="required"
		 maxlength="10" data-minlength="10"  /> 
		<form:errors  path="phone_number" /> </td>
		</tr>
		<tr>
		<td>User Type:</td>
		<td><form:radiobutton path="role" value="customer"/>Customer
        <form:radiobutton path="role" value="admin"/>Hotel Staff<font color="red"><form:errors
		path="role" /></font></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" value="Register User" /></td>
		</tr>
		</table> 
		</form:form>
</body>
</html>