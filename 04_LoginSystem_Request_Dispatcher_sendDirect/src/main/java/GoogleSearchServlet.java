import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/googleSearch")
public class GoogleSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		response.sendRedirect("https://www.google.com/search?q="+search+"&sxsrf=APq-WBv8IL5lBj8rqeZ1y8FrkspGIfisiQ%3A1646583566503&source"
				+ "=hp&ei=Dt8kYpq4HMfe2roP0cqymA4&iflsig=AHkkrS4AAAAAYiTtHgJ7sIRMGxwAiIALos-3mn6nWykG&ved=0ahUKEwia98nk8bH2AhVHr1YBHVGlDOMQ4"
				+ "dUDCAg&uact=5&oq=springboot&gs_lcp=Cgdnd3Mtd2l6EAMyBwgAEIAEEAoyBwgAEIAEEAoyBQgAEIAEMgcIABCABBAKMgcIABCABBAKMgcIABCABBAKMgUIA"
				+ "BCABDIHCAAQgAQQCjIHCAAQgAQQCjIHCAAQgAQQCjoHCCMQ6gIQJzoNCC4QxwEQrwEQ6gIQJzoECCMQJzoECAAQQzoLCAAQgAQQsQMQgwE6EQguEIAEELEDEIMBEM"
				+ "cBENEDOhAILhCxAxCDARDHARDRAxBDOgcILhDUAhBDOgoIABCxAxCDARBDOgcIABCxAxBDOg0ILhCxAxDHARDRAxBDOggILhCABBCxAzoOCC4QgAQQsQMQgwEQ1AI6C"
				+ "QgAEEMQRhCBAjoLCC4QgAQQxwEQrwE6CAgAEIAEELEDOgsILhCABBCxAxDUAlDFLliPS2CIUGgBcAB4AIABogKIAc8SkgEEMi0xMJgBAKABAbABCg&sclient=gws-wiz");	
	}

}
