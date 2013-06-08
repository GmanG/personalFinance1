package ua.home.model;

import java.math.BigDecimal;

import javax.ejb.Local;

@Local
public interface AddMoneyEJBLocal {
	
	void addMoney(BigDecimal sum, String descrip);

}
