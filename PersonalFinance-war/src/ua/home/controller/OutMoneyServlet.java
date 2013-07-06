package ua.home.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ua.home.entity.User;
import ua.home.model.BalanceEJBLocal;
import ua.home.model.BalanceStatusHandlerLocal;
import ua.home.model.CategoryHandlerEJBLocal;
import ua.home.model.MoneyManagerEJBLocal;
import ua.home.model.TypeCategoryHandlerEJBLocal;
import ua.home.model.UserHanlerEJBLocal;

/**
 * Servlet implementation class OutMoneyServlet
 */
@WebServlet("/OutMoneyServlet")
public class OutMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    @EJB
    private MoneyManagerEJBLocal moneyManager;
//    @EJB
//    private UserEJBLocal userHandler;
    @EJB
    private CategoryHandlerEJBLocal cat;
    @EJB
    private TypeCategoryHandlerEJBLocal type;
    @EJB
    private UserHanlerEJBLocal userHandler;
    @EJB
    private BalanceStatusHandlerLocal statusBalance;
    
	
    public OutMoneyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sumText = request.getParameter("amount");
		String description = request.getParameter("descrip");
		String statusName = "out";
		String categoryName = request.getParameter("category");
		String typeName = request.getParameter("type");
//		String email = ((String)request.getSession().getAttribute("mail@mail.com"));
		String email = "mail@mail.com";
		BigDecimal sum  = new BigDecimal(sumText);
		PrintWriter out = response.getWriter();
		out.print(description+" "+categoryName+" "+sumText+" "+typeName);
		
		
		User user = new User();
		
		try {
			user = userHandler.userCheck(email);
			moneyManager.addMoney(sum, description, user, cat.getCategoryByName(categoryName), type.getCategoryTypeByName(typeName), statusBalance.getStatusByName(statusName));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		request.getRequestDispatcher("start").forward(request, response);
		
	}

}
