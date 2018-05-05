<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<script>
function myFunction() {
    var x, text;
	var y;
    // Get the value of the input field with id="numb"
    x = document.getElementById("dateTo").value;
    y = document.getElementById("dateFrom").value;
    hotel = document.getElementById("hotel").value;
    var re = new RegExp("^([a-z0-9]{5,})$");

    document.getElementById("demo").innerHTML = result;
    // If x is Not a Number or less than one or greater than 10
    if (y>x) {
    	alert("Date not valid");
    	return false;
    } 
    if(re.test(hotel)){
    	return true;
     }
    else{
    	alert("Enter valid Hotel only alphabets allowed");
    	return false;
     }
}
</script>
<a href="${contextPath}/">logout</a>
<form action ="search.htm" method="GET">
<table>

<tr>
<td>Welcome : <%= session.getAttribute("userfirstname") %></td></tr>
<td>Check In Date:</td>
<td><input type="date" name="dateFrom" id="dateFrom" /></td>
<td>Check Out Date:</td>
<td><input type="date" name="dateTo" id="dateTo"/></td>
</tr>
<tr>
<td>Hotel:</td>
<td><input type="text" name ="keywordHotel" id="hotel" pattern="^[_A-z]{1,}$" ></td>
<tr>
<td>
<input type="submit" name ="submit" value ="Search" onclick="myFunction()"></td>
</table>
</form> 
</body>
</html>
