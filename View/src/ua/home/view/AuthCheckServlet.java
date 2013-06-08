package ua.home.view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.home.model.CategoryEJBLocal;
import ua.home.model.User;

/**
 * Servlet implementation class AuthCheckServlet
 */
@WebServlet("/authCheck")
public class AuthCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CategoryEJBLocal cat;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession(true);
		if (sess.getAttribute("email") != null) {
			User user = new User();
			request.setAttribute("cat", cat.getCategoryByUser(user));
			request.getRequestDispatcher("finance.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("index.html").forward(request,
					response);
		}

	}

}
