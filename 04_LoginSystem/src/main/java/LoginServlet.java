

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from user where email = '"+email+"' AND password = '"+password+"' ");
			int count = 0;
			while(rs.next()) {
				++count;
			}
//			out.print(count);
			if(count == 1) {
				request.setAttribute("message", "Welcome to iSecure Login System");
				RequestDispatcher rd = request.getRequestDispatcher("welcome");
				rd.forward(request, response);
			}
			else {
				out.print("<center><h3>Sorry, username or password incorrect Please try again</h3></center>");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			
		} catch (Exception e) {
			
		}
	}

}
