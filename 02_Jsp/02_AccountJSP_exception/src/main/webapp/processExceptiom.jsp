<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page errorPage = "error.jsp" %> 
    
    <%
    	int num1 = Integer.parseInt(request.getParameter("num1"));
    	int num2 = Integer.parseInt(request.getParameter("num2"));
    	int result = num1 / num2;
    	out.print("the result is : "+ result);
    %>