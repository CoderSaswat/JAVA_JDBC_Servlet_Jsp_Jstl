

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/targetServlet")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Cookie[] cookie = request.getCookies();
			for(int i=0;i<cookie.length;i++) {
				System.out.println(cookie[i].getName());
				System.out.println(cookie[i].getValue());
			}
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			HttpSession session = request.getSession();
			String n = (String)session.getAttribute("uname");
			out.print("from TargetServlet Heloo : "+n +" i remember you through session");
			out.print("<br/> <a href ='endSessionServlet'>click here to end the session</a>");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
