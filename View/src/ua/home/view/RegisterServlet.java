package ua.home.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.home.model.RegisterEJBLocal;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	private RegisterEJBLocal r;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = "";
		String password = "";
		email = request.getParameter("email");
		password = request.getParameter("password");
//		PrintWriter out = response.getWriter();
//		out.print("<html>");
//		out.print("text " +email+"/"+password);
//		out.print("</html>");
		r.userRegister(email, password);
		response.sendRedirect("ok.html");
	}

}
