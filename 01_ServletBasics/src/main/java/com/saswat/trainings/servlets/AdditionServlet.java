package com.saswat.trainings.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Long num1 = Long.parseLong(req.getParameter("number1"));
		Long num2 = Long.parseLong(req.getParameter("number2"));
		PrintWriter out = res.getWriter();
		out.println("the sum is "+ (num1+num2));
		out.println("heloo world");
	}

}
