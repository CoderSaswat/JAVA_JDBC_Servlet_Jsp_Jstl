package com.saswat.customtag.taglib;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ResultHandlerNew extends TagSupport {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement ps;
	public ResultHandlerNew() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy", "root", "root");
			ps = con.prepareStatement("select * from user where email = ? ");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int doStartTag() throws JspException {
		ServletRequest request = pageContext.getRequest();
		String email = request.getParameter("email");
		JspWriter out = pageContext.getOut();
		
		try {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				out.print("<h1>Usre details are</h1><br/>");
				out.print("First name : ");
				out.print(rs.getString(1));
				out.print("<br/>");
				out.print("Last name : ");
				out.print(rs.getString(2));
				out.print("<br/>");
				out.print("Password : ");
				out.print(rs.getString(4));				
			}
			else {
				out.print("invalid email id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Tag.SKIP_BODY;
		
	}
	
	@Override
	public void release() {
		try {
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
