<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterServlet" method="post">
	Userame: <input type="text" name="userName"><br>
	Password: <input type="password" name="password"><br>
	Email: <input type="text" name="email"><br>
	UserRole: <select name="userRole"><br>
		<option>user</option>
		<option>admin</option>
	</select>
	<br>
	<input type="submit" value="Create Account">
</form>
</body>
</html>