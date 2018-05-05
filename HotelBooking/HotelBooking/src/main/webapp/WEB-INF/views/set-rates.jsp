<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="${contextPath}/admin-dashboard.htm">Go Back</a><br/>
	<a href="${contextPath}/">logout</a>
	<h2>Add Room Rates</h2>

	<form:form action="setRoomRate.htm" method="POST"
		modelAttribute="roomRates">
		<input type="hidden" name="hotel" value="${hotel}" />
		<table>
			<tr>
				<td>Room Rate :</td>
				<td><form:select path="rate" items="${rates}" /></td>
			</tr>
			<tr>
				<td>Room Type:</td>
				<td><select id="room_type" name="room_type">
						<option value="Regular">Regular</option>
						<option value="Delux">Delux</option>
						<option value="Suite">Suite</option>
				</select></td>
			</tr>
			<tr>
		
				<td colspan="2"><input type="submit" value="Set Rates" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>