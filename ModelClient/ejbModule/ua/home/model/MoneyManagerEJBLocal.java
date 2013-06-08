package ua.home.model;

import java.math.BigDecimal;

import javax.ejb.Local;

@Local
public interface MoneyManagerEJBLocal {
	
	void addMoney(BigDecimal sum, String descrip, User user, Categorie cat, Categorietype type);

}
