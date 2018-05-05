<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rates Policy</title>
</head>
<body>

<script>
function myFunction() {
    var x, text;
	var y;
    // Get the value of the input field with id="numb"
    x = document.getElementById("dateTo").value;
    y = document.getElementById("dateFrom").value;
    //hotel = document.getElementById("hotel").value;
    var re = new RegExp("^([a-z0-9]{5,})$");

    document.getElementById("demo").innerHTML = result;
    // If x is Not a Number or less than one or greater than 10
    if (y>x) {
    	alert("Date not valid");
    	return false;}
}
</script>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a href="${contextPath}/admin-dashboard.htm">Go Back</a><br/>
	<a href="${contextPath}/">logout</a>
	<h1>Add Rates Policy</h1>
	<form:form action = "AddPolicy.htm" commandName="rate" method="POST">
	<table>
		<tr>
		<td>Policy Name:</td>
		<td> <form:input path="rate_name"  required="required" pattern="^[_A-z]{1,}$"/> </td>
		</tr>
		<tr>
		<td>Date from:</td>
		<td> <form:input type = "date" path="date_from" id="dateFrom" required="required" /> </td>
		</tr>
		<tr>
		<td>Date To:</td>
		<td> <form:input type = "date" path="date_to" id="dateTo" required="required" /> </td>
		</tr>
		<tr>
		<td>Price:</td>
		<td> <form:input path="price"  required="required" pattern="^[0-9]{1,}$"/> </td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" value="Add Policy" /></td>
		</tr>
	</table>
	</form:form>
</body>
</html>