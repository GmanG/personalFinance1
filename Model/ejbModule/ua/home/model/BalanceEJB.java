package ua.home.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class BalanceEJB
 */
@Stateless
@LocalBean
public class BalanceEJB implements BalanceEJBLocal {
	@PersistenceContext (unitName ="ModelJPA")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public BalanceEJB() {
        // TODO Auto-generated constructor stub
    }

//	@Override
//	public List<Balance> getUserTransaction() {
//		// TODO Auto-generated method stub
//		return em.createNativeQuery("findLastFiveTransaction").getResultList();
//	}

}
