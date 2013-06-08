package ua.home.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.iap.Response;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import ua.home.model.AddMoneyEJBLocal;
import ua.home.model.Balance;
import ua.home.model.User;

/**
 * Servlet implementation class AddMoneyServlet
 */
@WebServlet("/addmoney")
public class AddMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    AddMoneyEJBLocal addMoney;
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
//		String[] categorie = "";
		 
		sumText = request.getParameter("amount");
//		sum = (BigDecimal)request.getParameter("amount");
		descrip = request.getParameter("descrip");
		String categorie = Arrays.toString( request.getParameterValues("categorie"));
		String type = Arrays.toString(request.getParameterValues("type"));
		BigDecimal sum = new BigDecimal(sumText);
		Balance user = new Balance();
//		user.setUser("email");
//		user.setUser(((User)request.getSession().getAttribute("email")).getId());
//		addMoney.addMoney(sum, descrip);
//		request.getRequestDispatcher("start").forward(request, response);
//		PrintWriter out = response.getWriter();
//		out.print("<html>");
//		for (String string : categorie) {
//			out.print("<hr>"+string);	
//		}
//		
//		out.print("</html>");
		
	}

}
