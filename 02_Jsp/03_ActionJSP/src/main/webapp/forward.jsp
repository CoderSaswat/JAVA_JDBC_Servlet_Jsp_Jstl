<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>this is first page</h2>
	<jsp:forward page = "forward2.jsp">
		<jsp:param name="name" value="saswat kumar panda" />
	</jsp:forward>	
</body>
</html>