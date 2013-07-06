package ua.home.model;

import java.util.List;

import javax.ejb.Local;

import ua.home.entity.Balance;
import ua.home.entity.Balancestatus;
import ua.home.entity.User;

@Local
public interface BalanceEJBLocal {

	List<Balance> getUserTransaction(User user, Balancestatus status);
	 List getUserByName();
	 List getSome(); 
	 List getAll();
}
