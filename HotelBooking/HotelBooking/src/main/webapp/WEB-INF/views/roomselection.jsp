<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Confirmation</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<a href="${contextPath}/search.htm">Go Back</a><br/>
	<a href="${contextPath}/">logout</a>
	<h2>Booking Confirmation</h2>

	<form:form action="searchresult.htm" method="GET" modelAttribute="reserve">
		
		<input type="hidden" name="hotel" value="${hotel}" />
		<input type="hidden" name="roomid" value="${rid}" />
		<input type="hidden" name="userid" value="${uid}" />
		<table>
			<tr>
				<td>Guest Name :<input type="text" name="guestname" value="${username}" readonly></td>
			</tr>
			<tr>
				<td>Booking Amount :<input type="text" name="price" value="${price}" readonly></td>
			</tr>
			<tr>
				<td>Room Type :<input type="text" name="roomtype" value="${roomtype}" readonly></td>
			</tr>
			<tr>
				<td>CheckIn Date :<input type="text" name="dateFrom" value="${dateFrom}" size=50 readonly></td>
			</tr>
			<tr>
				<td>CheckOut Date :<input type="text" name="dateTo" value="${dateTo}" size=50 readonly></td>
			</tr>
				<td colspan="2"><input type="submit" value="Proceed to Book" /></td>
				<a href="home.htm">Cancel Booking</a>
			</tr>
		</table>
	</form:form>
</body>
</html>