package ua.home.model;

import java.math.BigDecimal;

import javax.ejb.Local;


import ua.home.entity.Category;
import ua.home.entity.Typecategory;
import ua.home.entity.User;

@Local
public interface MoneyManagerEJBLocal {
	
	void addMoney(BigDecimal sum, String descrip, User user, Category cat, Typecategory type);

}
