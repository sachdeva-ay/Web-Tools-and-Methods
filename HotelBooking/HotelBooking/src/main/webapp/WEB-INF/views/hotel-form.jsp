<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Hotel</title>
</head>
<body>

<a href="${contextPath}/admin-dashboard.htm">Go Back</a><br/>
<a href="${contextPath}/">logout</a>
	<h1>Add New Hotel</h1>

	
	<form:form commandName="hotel" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Hotel Name:</td>
				<td><form:input path="hotel_name" size="30" required="required" pattern="^[_A-z]{1,}$"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="hotel_address" size="30"
						required="required" pattern="^[_A-z,]{1,}$"/></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input path="hotel_city" size="30" required="required" pattern="^[A-z]{1,}$"/></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><form:input path="hotel_country" size="30"
						required="required" pattern="^[A-z]{1,}$" /></td>
			</tr>
			<tr>
				<td>Zipcode:</td>
				<td><form:input path="hotel_zipcode" size="30"
						required="required" pattern="^[0-9]{1,}$" maxlength="5"/></td>
			</tr>
			<tr>
				<td>Hotel Website:</td>
				<td><form:input path="hotel_url" size="30" required="required" pattern="^[0-9A-z@.]{1,}$"/></td>
			</tr>
			<tr>
				<td>Hotel Description:</td>
				<td><form:input path="hotel_description" size="30"
						required="required" pattern="^[0-9A-z@.]{1,}$"/></td>
			</tr>
			<tr>
				<td>location:</td>
				<td><form:input path="hotel_location" size="30"
						required="required" pattern="^[0-9A-z@.]{1,}$"/></td>
			</tr>
			<tr>
				<td>Upload Photos:</td>
				<td><form:input path="photo" type="file" size="30"
						required="required" multiple="multiple" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Hotel" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>