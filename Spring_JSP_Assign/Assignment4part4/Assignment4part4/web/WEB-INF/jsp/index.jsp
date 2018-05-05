<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        
        <c:if test="${empty requestScope.soList && empty requestScope.success}">
        <form method="get" action="load.htm">
             <h2>File name(.csv):</h2>
        <input type="text" name="filename">
        <input type="hidden" name="action" value="load">
        <input type="submit" value="Load File">
        </form>
        </c:if>
        <c:if  test="${!empty requestScope.soList}">
        <form method="get" action="insert.htm">
        <table border="1">
         <tr>
                <th>SalesOrderID</th>
                <th>RevisionNumber</th>
                <th>OrderDate</th>
                <th>DueDate</th>
                <th>ShipDate</th>
                <th>Status</th>
                <th>OnlineOrderFlag</th>
                <th>SalesOrderNumber</th>
                <th>PurchaseOrderNumber</th>
                <th>AccountNumber</th>
                <th>CustomerID</th>
                <th>SalesPersonID</th>
                <th>TerritoryID</th>
                <th>BillToAddressID</th>
                <th>ShipToAddressID</th>
                <th>ShipMethodID</th>
                <th>CreditCardID</th>
                <th>CreditCardApprovalCode</th>
                <th>CurrencyRateID</th>
                <th>SubTotal</th>
                <th>TaxAmt</th>
                <th>Freight</th>
                <th>TotalDue</th>
                <th>Comment</th>
                <th>ModifiedDate</th>

            </tr>
       <c:forEach items="${requestScope.soList}" var="so">
        
            <tr>
                <td><input type="text" name="salesOrderID" value="${so.salesOrderID}"></td>
                <td><input type="text" name="revisionNumber" value="${so.revisionNumber}"></td>
                <td><input type="text" name="orderDate" value="${so.orderDate}"></td>
                <td><input type="text" name="dueDate" value="${so.dueDate}"></td>
                <td><input type="text" name="shipDate" value="${so.shipDate}"></td>
                <td><input type="text" name="status" value="${so.status}"></td>
                <td><input type="text" name="onlineOrderFlag" value="${so.onlineOrderFlag}"></td>
                <td><input type="text" name="salesOrderNumber" value="${so.salesOrderNumber}"></td>
                <td><input type="text" name="purchaseOrderNumber" value="${so.purchaseOrderNumber}"></td>
                <td><input type="text" name="accountNumber" value="${so.accountNumber}"></td>
                <td><input type="text" name="customerID" value="${so.customerID}"></td>
                <td><input type="text" name="salesPersonID" value="${so.salesPersonID}"></td>
                <td><input type="text" name="territoryID" value="${so.territoryID}"></td>
                <td><input type="text" name="billToAddressID" value="${so.billToAddressID}"></td>
                <td><input type="text" name="shipToAddressID" value="${so.shipToAddressID}"></td>
                <td><input type="text" name="shipMethodID" value="${so.shipMethodID}"></td>
                <td><input type="text" name="creditCardID" value="${so.creditCardID}"></td>
                <td><input type="text" name="creditCardApprovalCode" value="${so.creditCardApprovalCode}"></td>
                <td><input type="text" name="currencyRateID" value="${so.currencyRateID}"></td>
                <td><input type="text" name="subTotal" value="${so.subTotal}"></td>
                <td><input type="text" name="taxAmt" value="${so.taxAmt}"></td>
                <td><input type="text" name="freight" value="${so.freight}"></td>
                <td><input type="text" name="totalDue" value="${so.totalDue}"></td>
                <td><input type="text" name="comment" value="${so.comment}"></td>
                <td><input type="text" name="modifiedDate" value="${so.modifiedDate}"></td>

            </tr>
       </c:forEach>
        </table>   
            
            <input type="hidden" name="action" value="insert">
            <input type="submit" value="submit">
            </form>
        </c:if>
        <c:if test="${!empty requestScope.success}">
            <h1>Successfully inserted</h1>
        </c:if>
    </body>
</html>
