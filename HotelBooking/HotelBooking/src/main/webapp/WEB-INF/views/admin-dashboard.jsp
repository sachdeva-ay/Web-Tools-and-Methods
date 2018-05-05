<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin-Page</title>
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<a href="${contextPath}/admin-dashboard.htm">Go Back</a><br/>
	<a href="${contextPath}/">logout</a>
<h1>ADMIN DASHBOARD</h1>
<a href="policy.htm">Add Policies</a>
<a href="${contextPath}/hotelManage.htm">Add New Hotel</a>
<a href="${contextPath}/roomAdd.htm">Add New Rooms</a>
<a href="${contextPath}/setRate.htm">Set Room Rates</a>
</body>
</html>