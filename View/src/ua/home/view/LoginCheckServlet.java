package ua.home.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.home.model.LoginEJBLocal;

import ua.home.model.User;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private LoginEJBLocal login;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String email = "";
		String password = "";
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		try {
			User user = login.userCheckLogin(email, password);
//			response.set
			request.getSession().setAttribute("email", email);
//			response.sendRedirect("finance.jsp");
			request.getRequestDispatcher("finance.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//			out.print("<html>"+email+"/"+password+"</html>");
			response.sendRedirect("error.html");
		}
	}

}
