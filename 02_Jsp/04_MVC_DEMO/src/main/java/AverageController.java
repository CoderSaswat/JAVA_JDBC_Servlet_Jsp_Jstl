

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/averageController")
public class AverageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		AverageCalculator model =new AverageCalculator();
		int result = model.calculateAverage(num1,num2);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
