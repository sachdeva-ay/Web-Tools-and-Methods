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
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="temp" value="${0}"/>
	<a href="${contextPath}/search.htm">Go Back</a><br/>
	<a href="${contextPath}/">logout</a>
<form>
 <c:choose>
            <c:when test="${empty searchedHotel}">
                <h3>No Hotels Found !</h3>                
        </c:when>
                <c:otherwise>
    <input type="hidden" name="dateTo" value="${dateTo}" />
    <input type="hidden" name="dateFrom" value="${dateFrom}"/>
    Check In Date:<c:out value="${dateFrom}"/><br>
    Check Out Date: <c:out value="${dateTo}"/> <br>
    
    <br>
	<c:forEach var="hotel" items="${searchedHotel}">
		
	<c:if test="${not(temp eq hotel[0])}">
	 <a href = "${contextPath}/bookHotel.htm?hotel=${hotel[1]}&hotelrate=${hotel[3]}
	 &dateFrom=${dateFrom}&dateTo=${dateTo}&roomid=${hotel[6]}&userid=<%= session.getAttribute("userid") %>">
	 
	    Book Hotel :<c:out value="${hotel[1]}"/> <br></a>
		Hotel photo :<c:out value="${hotel[2]}"/><br>
		Hotel Rate: <c:out value="${hotel[3]}" /><br>
		Room Type: <c:out value="${hotel[4]}" /><br>
		
		<input type="hidden" name="myObject" value="${hotel[3]}" />
    </c:if>
		<c:set var="temp" value="${hotel[1]}" />
		<br>
	</c:forEach>
	        </c:otherwise>
       </c:choose>
      
</form>

</body>
</html>