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
import ua.home.model.User;
import ua.home.model.UserEJBLocal;

/**
 * Servlet implementation class Show
 */
@WebServlet("/show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UserEJBLocal users;
	@EJB
	private CategoryEJBLocal cat;
	@EJB
    private UserEJBLocal userHandler;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		List<User> u = users.getUsers();
//		request.setAttribute("u", u);
		
		String email = (String)request.getSession().getAttribute("email");
		User user =  new User();
		try {
			user = userHandler.userCheck(email);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Categorie> cate = cat.getCategoryByUser(user);
//		List<Categorie> cate = cat.getCategoryByUser1();
		request.setAttribute("cate", cate);
		request.getRequestDispatcher("finance.jsp").forward(request,response);
//		PrintWriter out = response.getWriter();
//		out.print("<html>");
//		for (Categorie  catee : cate) {
//			out.print("<hr>"+catee.getName());
//		}
//		out.print("</html>");

	}
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		super.doGet(req, resp);
////		List<User> u = users.getUsers();
//		req.setAttribute("u", users.getUsers());
//		req.getRequestDispatcher("table.jsp").forward(req,resp);
//	}

}

