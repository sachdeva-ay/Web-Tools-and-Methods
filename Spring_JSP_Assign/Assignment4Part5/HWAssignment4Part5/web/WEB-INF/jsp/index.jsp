<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="ex" uri="/WEB-INF/tlds/custom.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSV File Connection</title>
    </head>

    <body><c:if test="${empty requestScope.connection}">
        <form name='myForm' method="post" action="connectFile.htm">
                <h3>Name of the CSV file:</h3>
                <input type="text" name="filename" />
                <input type="submit" name="action" value="Submit"/>
                <br>
                <ex:SalesHandler filename="${sessionScope.filename}"></ex:SalesHandler>
           </c:if>     
        </form>  
                <br>
                <c:if test="${requestScope.connection==false}">
      <h1><c:out value="${sessionScope.length}" /> salesorder added successfully.</h1>
      </c:if>
      <c:if test="${requestScope.file==true}">
      <h1>No file found</h1>
        </c:if>
    </body>
</html>
