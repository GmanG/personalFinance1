package ua.home.model;

import java.math.BigDecimal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ua.home.entity.Balance;
import ua.home.entity.Category;
import ua.home.entity.Typecategory;
import ua.home.entity.User;

/**
 * Session Bean implementation class AddMoneyEJB
 */
@Stateless
@LocalBean
public class MoneyManagerEJB implements MoneyManagerEJBLocal {
	@PersistenceContext (name = "ModelJPA")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public MoneyManagerEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addMoney(BigDecimal sum, String descrip, User user, Category cat, Typecategory type) {
		// TODO Auto-generated method stub
		Balance balance = new Balance();
		balance.setSum(sum);
		balance.setDescription(descrip);
		balance.setUser(user);
		balance.setCategory(cat);
		balance.setTypecategory(type);
		em.merge(balance);
		
	}

}
