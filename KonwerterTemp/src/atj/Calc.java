package atj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Double val1 = Double.parseDouble(request.getParameter("val1"));
		String operacja = request.getParameter("operacja");
		
		
		Double result = calc(val1, operacja);
		response.getWriter().println("<h1>"+result+"</h1>");
		
		request.getSession().setAttribute("result", result);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("res.jsp");
		requestDispatcher.forward(request,  response);
	}

	protected double calc(double val1, String operacja) {
		double result =0;
		if (operacja.equals("Celcjusz")) {
		result = (val1 - 32) / 1.8;
		return result;
		}
		else if (operacja.equals("Fahrenheit")) {
		result = (val1 * 1.8) + 32;
		return result;
		}
			return result;

	}

}
