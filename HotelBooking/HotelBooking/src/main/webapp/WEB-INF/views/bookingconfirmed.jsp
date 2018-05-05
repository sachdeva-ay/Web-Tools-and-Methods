<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
	

<form:form action=".htm" method="GET">
<a href="${contextPath}/home.htm">Go Back</a><br/>
<a href="${contextPath}/">logout</a>

Booking Confirmed for Hotel :<c:out value="${hotelname}"/> from <c:out value="${dateFrom}"/> 
to <c:out value="${dateTo}"/><br><br>

Your reservation id is: <c:out value="${reservationid}"/>

<input type="submit" value="Book another hotel" />			
</form:form>

</body>
</html>