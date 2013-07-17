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

import ua.home.entity.Category;
import ua.home.entity.Typecategory;
import ua.home.entity.User;
import ua.home.model.CategoryHandlerEJBLocal;
import ua.home.model.TypeCategoryHandlerEJBLocal;
import ua.home.model.UserHanlerEJBLocal;

import com.google.gson.Gson;

/**
 * Servlet implementation class UserTypeServlet
 */
@WebServlet("/UserTypeServlet")
public class UserTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UserHanlerEJBLocal userHandler;
	@EJB
	private CategoryHandlerEJBLocal categoryHandler;
	@EJB
	private TypeCategoryHandlerEJBLocal typeHandler;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    response.setHeader("Cache-control", "no-cache, no-store");
	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Expires", "-1");
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	    response.setHeader("Access-Control-Max-Age", "86400");
	    
	    String email = request.getParameter("email");
		User user = new User();
		try {
			user = userHandler.userCheck(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Typecategory> type = typeHandler.getAllTypeCategory(user);
		PrintWriter out = response.getWriter();
		String typeJson = "";
		Gson gson  = new Gson();
		
		typeJson = gson.toJson(type);
		out.print(typeJson);
		System.out.println(typeJson);
	}

}
