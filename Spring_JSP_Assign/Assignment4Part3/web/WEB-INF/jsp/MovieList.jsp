<%-- 
    Document   : MovieList
    Created on : 12 Feb, 2017, 2:24:19 AM
    Author     : Hp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter the data:</h1>
        <form method="get" action="addBooks.htm">
        <table>
            <tr>
                <td>ISBN</td>
                <td>Book Title</td>
                <td>Authors</td>
                <td>Price</td>
            </tr> 
            <c:forEach varStatus="i" begin="1" end="${requestScope.count}">
                <tr>
                    <td><input type="text" name="isbn"></td>
                    <td><input type="text" name="title"></td>
                    <td><input type="text" name="author"></td>
                    <td><input type="text" name="price"></td>
                </tr>    
            </c:forEach>    
        </table>    
            <input type="hidden" name="hidden" value="${requestScope.count}">
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
