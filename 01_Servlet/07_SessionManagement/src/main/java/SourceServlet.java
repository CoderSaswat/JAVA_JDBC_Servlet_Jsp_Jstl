

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Cookie[] cookie = request.getCookies();
			for(int i=0;i<cookie.length;i++) {
				System.out.println(cookie[i].getName());
				System.out.println(cookie[i].getValue());
			}
			response.addCookie(new Cookie("securityToken", "12345"));
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String n = request.getParameter("username");
			out.println("from SourceServlet Welcome : "+n);
			
			HttpSession session = request.getSession();
			session.setAttribute("uname", n);
			out.print("<br/><a href='targetServlet'>click to see if state is managed or not in another servlet </a>");//that is session is active or not
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
