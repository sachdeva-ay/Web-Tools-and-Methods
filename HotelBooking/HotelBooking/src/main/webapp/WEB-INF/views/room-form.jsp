<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Rooms</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a href="${contextPath}/admin-dashboard">Go Back</a><br/>
	<a href="${contextPath}/">logout</a>
	<h2>Add New Rooms</h2>

	<form:form action= "addroom.htm" method="post" modelAttribute="room">
		<table>
			<tr>
				<td>Hotel:</td>
				<td><form:select path="hotel.hotel_name" items="${hotellist}" /></td>
			</tr>
			<tr>
				<td>Room Number:</td>
				<td><form:input type="number" path="room_number" size="30" required="required" pattern="^[0-9]{1,}$"/></td>
			</tr>
			<tr>
				<td>Room Type:</td>
				<td>
				<%-- <form:select path="room_type" items="${roomType}" /> --%>
				
				<select id="room_type" name="room_type">
				   <option value="Regular">Regular</option>
				   <option value="Delux">Delux</option>
				   <option value="Suite">Suite</option>
				   </select>
				</td>
			</tr>
			<tr>
				<td>Amenities:</td>
				<td><form:input type="text" path="amenities" size="30" required="required" pattern="^[_A-z0-9]{1,}$"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Room" /></td>
			</tr>
		</table>
	</form:form>


</select>
</form>
</body>
</html>