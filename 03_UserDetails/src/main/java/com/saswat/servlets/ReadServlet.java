package com.saswat.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	
    public void init() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy", "root", "root");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			java.sql.Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery("select * from user");
			PrintWriter out = response.getWriter();
			
			out.println("<table>"); 
			
				out.println("<tr>");
				
					out.println("<th>");
					out.println("First Name");
					out.println("</th>");
					
					out.println("<th>");
					out.println("Last Name");
					out.println("</th>");
					
					out.println("<th>");
					out.println("Email-id");
					out.println("</th>");
					
				out.println("</tr>");
			
			while(res.next()) {
				
				out.println("<tr>");
				
					out.println("<td>");
					out.print(res.getNString(1));
					out.println("</td>");
					
					out.println("<td>");
					out.print(res.getNString(2));
					out.println("</td>");
					
					out.println("<td>");
					out.print(res.getNString(3));
					out.println("</td>");
				
				out.println("</tr>");
			}
			
			out.println("</table>");
			
			
		} catch (Exception e) {
			
		}
	}
	
	
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
