package ua.home.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.home.model.Categorie;
import ua.home.model.CategoryEJBLocal;
import ua.home.model.LoginEJBLocal;
import ua.home.model.UserEJBLocal;

import ua.home.model.User;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private LoginEJBLocal login;
	@EJB
	private UserEJBLocal users;
	@EJB
	private CategoryEJBLocal cat;
	@EJB
    private UserEJBLocal userHandler;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = "";
		String password = "";
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		try {
			User user = login.userCheckLogin(email, password);
			List<Categorie> cate = cat.getCategoryByUser(user);
			request.setAttribute("cate", cate);
			request.getSession().setAttribute("email", email);
			request.getRequestDispatcher("finance.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("error.html");
		}
	}

}
