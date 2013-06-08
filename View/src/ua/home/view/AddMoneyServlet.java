package ua.home.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.iap.Response;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import ua.home.model.Categorie;
import ua.home.model.Categorietype;
import ua.home.model.CategoryEJBLocal;
import ua.home.model.CategoryTypeEJBLocal;
import ua.home.model.LoginEJBLocal;
import ua.home.model.MoneyManagerEJBLocal;
import ua.home.model.Balance;
import ua.home.model.User;
import ua.home.model.UserEJBLocal;

/**
 * Servlet implementation class AddMoneyServlet
 */
@WebServlet("/addmoney")
public class AddMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private MoneyManagerEJBLocal moneyManager;
    @EJB
    private UserEJBLocal userHandler;
    @EJB
    private CategoryEJBLocal cat;
    @EJB
    private CategoryTypeEJBLocal type;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMoneyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sumText = "";
		String descrip = "";
		String email = "";
		 
		sumText = request.getParameter("amount");
		descrip = request.getParameter("descrip");
		BigDecimal sum = new BigDecimal(sumText);
		String catName = request.getParameter("category");
		String typeName = request.getParameter("type");
//		User user;
		
//		email =email+ "";
		
		
		
//		try {
//			User user = userHandler.getUserByEmail(email);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("==========================------------------------"+e);
//		}
//		user
//		List<User> user = null;
		email = ((String)request.getSession().getAttribute("email"));
		User user = new User();
		try {
			user = userHandler.userCheck(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		PrintWriter out = response.getWriter();
//		out.print("<html>");
		
		
//			out.print("<hr> user exist");
//		out.print("</html>");
		moneyManager.addMoney(sum, descrip, user, cat.getCategoryByName(catName), type.getCategoryTypeByname(typeName));
//		List<Categorie> cat;
//		List<Categorietype> type;
//		users = user.getUserByEmail(email);
//		Balance user = new Balance();
//		user.setUser("email");
//		user.setUser(((User)request.getSession().getAttribute("email")).getId());
//		addMoney.addMoney(sum, descrip);
//		request.getSession().setAttribute("email", email);
		request.getRequestDispatcher("start").forward(request, response);
//		PrintWriter out = response.getWriter();
//		out.print("<html>");
//		for (String string : categorie) {
//			out.print("<hr>"+string);	
//		}
//		
//		out.print("</html>");
		
	}

}
