<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL core tags</title>
</head>
<body>
	<h3>c:out</h3>
	<c:out value="${'hy this cout tag of jstl'}"></c:out>

	<h3>c:include</h3>
	<c:import url="https://www.google.com"></c:import>
	<%-- <c:out value="${data}"></c:out> --%>

	<h3>c:set</h3>
	<c:set var="income" scope="session" value="${1000*5}"></c:set>
	<c:out value="${income}"></c:out>

	<h3>c:remove</h3>
	<c:remove var="income" />

	<h3>c:if</h3>
	<c:set var="age" value="19"></c:set>
	<c:if test="${age > 18}">
		<h2>u r allowed to the party</h2>
	</c:if>

	<h3>c:choose, c:when, c:otherwise</h3>
	<h3>this is like switch,case,default</h3>
	<c:set var="age" value="99"></c:set>
	<c:choose>
		<c:when test="${age < 18}">
			<h2>u r a teenager</h2>
		</c:when>
		<c:when test="${age >= 18 && age <60}">
			<h2>u r an adult youth</h2>
		</c:when>
		<c:otherwise>
			<h2>you are an old man</h2>
		</c:otherwise>
	</c:choose>

	<h3>c:forEach</h3>
	<c:forEach var="i" begin="1" end="10">
		<c:out value="${i}"></c:out>
		<br>
	</c:forEach>
</body>
</html>