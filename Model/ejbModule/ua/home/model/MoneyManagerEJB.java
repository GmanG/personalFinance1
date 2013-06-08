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
	public void addMoney(BigDecimal sum, String descrip, User user, Categorie cat, Categorietype type) {
		// TODO Auto-generated method stub
		Balance balance = new Balance();
		balance.setSum(sum);
		balance.setDescrip(descrip);
//		balance.setUser()
		balance.setUser(user);
		balance.setCategorie(cat);
		balance.setCategorietype(type);
		em.merge(balance);
//		user.addBalance()
		
		
	}

}
