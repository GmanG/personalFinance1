package ua.home.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.ejb.Local;


import ua.home.entity.Balance;
import ua.home.entity.Balancestatus;
import ua.home.entity.Category;
import ua.home.entity.Typecategory;
import ua.home.entity.User;

@Local
public interface MoneyManagerEJBLocal {
	
	void addMoney(BigDecimal sum, String descrip, User user, Category cat, Typecategory type, Balancestatus status);
	BigDecimal getotalMoney(User user);
	BigDecimal getSumByUserAndStatus(User user, Balancestatus status);
	BigDecimal gettotalMoney(User user);
	Balance  getSumByUserAndStatus1(User user, Balancestatus status);
	List<Balance> getSumByUserAndStatus2(User user, Balancestatus status);

}
