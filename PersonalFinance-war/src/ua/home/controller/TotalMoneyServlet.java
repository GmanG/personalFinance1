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

import ua.home.entity.Balancestatus;
import ua.home.entity.User;
import ua.home.model.BalanceStatusHandlerLocal;
import ua.home.model.MoneyManagerEJBLocal;
import ua.home.model.UserHanlerEJBLocal;

/**
 * Servlet implementation class TotalMoneyServlet
 */
@WebServlet("/totalMoney")
public class TotalMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private BalanceStatusHandlerLocal status;
	@EJB
	private MoneyManagerEJBLocal moneyManager;
	@EJB
	private UserHanlerEJBLocal userHandler;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotalMoneyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		User user = new User();
		try {
			user = userHandler.userCheck(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Balancestatus comeStatus = status.getStatusByName("come");
		Balancestatus outStatus = status.getStatusByName("out");
		String comeText = (moneyManager.getSumByUserAndStatus(user, comeStatus)).toString();
		String outText = (moneyManager.getSumByUserAndStatus(user, outStatus)).toString();
		BigDecimal come = new BigDecimal(comeText.replaceAll("\\[|\\]", ""));
		BigDecimal out = new BigDecimal(outText.replaceAll("\\[|\\]", ""));
		BigDecimal total = come.subtract(out);
		PrintWriter outW = response.getWriter();
		outW.print(total);
	}

}
