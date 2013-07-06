package ua.home.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ua.home.entity.Balance;
import ua.home.entity.Balancestatus;
import ua.home.entity.User;
import ua.home.model.BalanceEJBLocal;
import ua.home.model.BalanceStatusHandlerLocal;
import ua.home.model.UserHanlerEJBLocal;

/**
 * Servlet implementation class OutTransactionInfoServlet
 */
@WebServlet("/OutTransactionInfoServlet")
public class OutTransactionInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private BalanceEJBLocal balance;
	@EJB
	private UserHanlerEJBLocal userHandler;
	@EJB
	private BalanceStatusHandlerLocal status;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutTransactionInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Balancestatus outStatus = status.getStatusByName("out");
		User user = new User();
		response.setContentType("text/html");
	    response.setHeader("Cache-control", "no-cache, no-store");
	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Expires", "-1");
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	    response.setHeader("Access-Control-Max-Age", "86400");
	    PrintWriter out = response.getWriter();
	    String json = "";
			try {
				user = userHandler.userCheck("mail@mail.com");
				List<Balance> userTransaction = balance.getUserTransaction(user, outStatus);
				System.out.println(userTransaction.toString());
//				System.out.println("--------------------------------OK-------------");
//				JsonArray jsonArray = new JsonArray();
////				System.out.println("--------------------------------OK-------------");
//				json = new Gson().toJson(userTransaction);
//				System.out.println(json.toString());
				Gson gson = new Gson();
				json = gson.toJson(userTransaction);

				out.write(json);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
//		
//		String respMess = "AJAX POST check " + "data saved ";
//        response.setContentType("text/plain");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(respMess);


	}

}
