package ua.home.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ua.home.entity.Balance;
import ua.home.entity.Balancestatus;
import ua.home.entity.Category;
import ua.home.entity.Typecategory;
import ua.home.entity.User;

/**
 * Session Bean implementation class AddMoneyEJB
 */
@Stateless
@LocalBean
public class MoneyManagerEJB implements MoneyManagerEJBLocal {
	@PersistenceContext(name = "ModelJPA")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public MoneyManagerEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addMoney(BigDecimal sum, String descrip, User user,
			Category cat, Typecategory type, Balancestatus status) {
		// TODO Auto-generated method stub
		Balance balance = new Balance();
		balance.setSum(sum);
		balance.setDescription(descrip);
		balance.setUser(user);
		balance.setCategory(cat);
		balance.setTypecategory(type);
		balance.setStatus(status);
		em.merge(balance);

	}

	@Override
	public BigDecimal gettotalMoney(User user) {
		// TODO Auto-generated method stub
		em.createNamedQuery("Balance.getTotalSum").setParameter("user", user);
		return null;
	}

	//
	// @Override
	// public BigDecimal getotalMoney(User user) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	@Override
	public BigDecimal getSumByUserAndStatus(User user, Balancestatus status) {
		// TODO Auto-generated method stub
		// return (BigDecimal)
		// em.createNamedQuery("Balance.getSumByUserAndStatus").setParameter("user",
		// user).setParameter("status", status).getResultList();
		List<Balance> b = em.createNamedQuery("Balance.getSumByUserAndStatus")
				.setParameter("user", user).setParameter("status", status)
				.getResultList();
		Iterator i = b.iterator();
		BigDecimal d = new BigDecimal(0);
//		while (i.hasNext()) {
//			d = (BigDecimal) i;
//			
//		}
		for (Balance balance : b) {
		   d=	balance.getSum();
		}
		
		return d;
	}

	@Override
	public BigDecimal getotalMoney(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Balance getSumByUserAndStatus1(User user, Balancestatus status) {
		// TODO Auto-generated method stub
		return (Balance) em.createNamedQuery("Balance.getSumByUserAndStatus")
				.setParameter("user", user).setParameter("status", status)
				.getSingleResult();

	}

	@Override
	public List<Balance> getSumByUserAndStatus2(User user, Balancestatus status) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Balance.getSumByUserAndStatus")
				.setParameter("user", user).setParameter("status", status)
				.getResultList();
	}

}
