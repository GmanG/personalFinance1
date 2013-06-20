package ua.home.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ua.home.entity.Balance;
import ua.home.entity.User;
import ua.home.model.UserHanlerEJBLocal;



/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	@EJB
//	private LoginEJBLocal login;
//	@EJB
//	private UserEJBLocal users;
//	@EJB
//	private CategoryEJBLocal cat;
//	@EJB
//    private UserEJBLocal userHandler;
//	@EJB
//	private BalanceEJBLocal balance;
	@EJB
	private UserHanlerEJBLocal login;
//	@EJB
//	private 
//	
       
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
//		PrintWriter out = response.getWriter();
		String email = "";
		String password = "";
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		try {
			User user = login.userCheckLogin(email, password);
//			List<Categorie> cate = cat.getCategoryByUser(user);
//			request.setAttribute("cate", cate);
//			balance.getUserByName();
//			List<Balance> result = balance.getUserTransaction(user);
//			Gson gSon =  new Gson();
//			List all =  balance.getAll();
//			PrintWriter out = response.getWriter();
//			out.print("<html>");
//			Iterator i = result.iterator();
//			while (i.hasNext()){
//				Object[] o = (Object[]) i.next();
//				for (int j = 0; j < o.length; j++) {
//					out.print("<br>" +o[j]);
//				}
//				
//			}
//			out.print("<hr>"+gSon.toJson(result));
//			out.print("<hr>"+result);
//			out.print("</html>");
//			List<Balance> lastCate = balance.getUserTransaction(user);
//			request.setAttribute("result", result);
//			request.setAttribute("cate", cate)
			request.getSession().setAttribute("email", email);
			request.getRequestDispatcher("finance.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("error.html");
			System.out.println("*****************************************************************"+e);
		}
	}

}
