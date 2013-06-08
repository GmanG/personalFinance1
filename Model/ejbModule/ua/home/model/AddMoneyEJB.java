package ua.home.model;

import java.math.BigDecimal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class AddMoneyEJB
 */
@Stateless
@LocalBean
public class AddMoneyEJB implements AddMoneyEJBLocal {
	@PersistenceContext (name = "ModelJPA")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public AddMoneyEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addMoney(BigDecimal sum, String descrip) {
		// TODO Auto-generated method stub
		Balance balance = new Balance();
		balance.setSum(sum);
		balance.setDescrip(descrip);
//		balance.setUser()
		em.merge(balance);
		user.addBalance()
		
		
	}

}
