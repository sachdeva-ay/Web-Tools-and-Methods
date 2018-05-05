<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="userlogin.htm" method="post" >
Username: <input type="text" name="username"><br>
Password: <input type="password" name ="password"><br>
<br>
<input type="checkbox" name="role" id="role" value="admin" tabindex="2" >Check this box if you are a Admin/HotelManager?<label></label>
<br>
<input type="submit" name="submit" value="login"><br>
<a href="UserRegistration.htm">Don't have a account? Register here</a>
</form>
</body>
</html>