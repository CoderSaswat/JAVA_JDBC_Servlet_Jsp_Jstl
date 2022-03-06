package com.saswat.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

//note - init params can also be configured by web.xml file see web.xml for more details

@WebServlet(urlPatterns = "/readServletInitParams", initParams ={ @WebInitParam(name = "dbUrl", value = "jdbc:mysql://localhost:3306/udemy"),
																  @WebInitParam(name = "dbUsername", value = "root"), 
																  @WebInitParam(name = "dbPassword", value = "root")} )
public class ReadServletInitParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	
    public void init(ServletConfig config) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection( config.getInitParameter("dbUrl"),
												   config.getInitParameter("dbUsername"),
												   config.getInitParameter("dbPassword") );
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
