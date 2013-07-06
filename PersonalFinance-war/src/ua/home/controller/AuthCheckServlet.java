package ua.home.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.home.entity.Category;
import ua.home.entity.User;
import ua.home.model.CategoryHandlerEJBLocal;
import ua.home.model.UserHanlerEJBLocal;

/**
 * Servlet implementation class AuthCheckServlet
 */
@WebServlet("/authCheck")
public class AuthCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	@EJB
//	private UserEJBLocal users;
	@EJB
//	private CategoryEJBLocal cat;
	private CategoryHandlerEJBLocal cat;
	@EJB
    private UserHanlerEJBLocal userHandler;

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
			String email = (String)request.getSession().getAttribute("email");
			User user =  new User();
			try {
				user = userHandler.userCheck(email);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			List<Category> cate = cat.getCategoryByUser(user);
//			List<Categorie> cate = cat.getCategoryByUser1();
//			request.setAttribute("cate", cate);
			request.getRequestDispatcher("finance.jsp").forward(request,response);
//			List<User> u = users.getUsers();
//			request.setAttribute("u", u);
			
		} else {
			request.getRequestDispatcher("index.html").forward(request,	response);
		}

	}

}
