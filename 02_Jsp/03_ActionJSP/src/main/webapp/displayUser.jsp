<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>fetching through bean</title>
</head>
<body>
	<jsp:useBean id="user" class="com.saswat.jsp.User">
		<jsp:setProperty name="user" property="*" />
	</jsp:useBean>
	
	<h3>User Details</h3>
	Name : <jsp:getProperty property="name" name="user"/><br/>
	Mark : <jsp:getProperty property="mark" name="user"/><br/>
	Email : <jsp:getProperty property="email" name="user"/><br/>
	Age : <jsp:getProperty property="age" name="user"/><br/>
</body>
</html>