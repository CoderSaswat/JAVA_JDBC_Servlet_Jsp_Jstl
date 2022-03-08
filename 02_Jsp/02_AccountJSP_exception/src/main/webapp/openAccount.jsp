<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%!
	Connection con;
	PreparedStatement ps;
	
	public void jspInit(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy", "root", "root");
			ps = con.prepareStatement("insert into account values(?,?,?,?)");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public void jspDestroy(){
		try{
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

%>

<% 
	int accno = Integer.parseInt(request.getParameter("accno"));
	String lastName = request.getParameter("lastName");
	String firstName = request.getParameter("firstName");
	int balance = Integer.parseInt(request.getParameter("balance"));
	
	ps.setInt(1, accno);
	ps.setString(2, lastName);
	ps.setString(3, firstName);
	ps.setInt(4, balance);
	
	ps.executeUpdate();
	response.sendRedirect("create.html");
%>