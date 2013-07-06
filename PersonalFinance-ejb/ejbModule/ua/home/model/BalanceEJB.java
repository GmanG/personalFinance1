package ua.home.model;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ua.home.entity.Balance;
import ua.home.entity.Balancestatus;
import ua.home.entity.User;

/**
 * Session Bean implementation class BalanceEJB
 */
@Stateless
@LocalBean
public class BalanceEJB implements BalanceEJBLocal {
	@PersistenceContext (unitName ="ModelJPA")
	EntityManager em;
	@EJB
	UserHanlerEJBLocal users;

    /**
     * Default constructor. 
     */
    public BalanceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List getUserTransaction(User user,  Balancestatus status) {
		// TODO Auto-generated method stub
//		return em.createNativeQuery("select * from Balance b", "BalanceWithCategoryType").getResultList();
		return em.createNamedQuery("Balance.findLastFiveTransaction").setParameter("user", user).setParameter("status", status).getResultList();
	}
//	public void getUserByName(){
//		User user  = users.getUserByEmail("mail@mail.com");
////		List result = em.createNamedQuery("findLastFiveTransaction").setParameter("user", user).getResultList();
//		List result = em.createNativeQuery("select * from User").getResultList();
//		Iterator i = result.iterator();
//		while(i.hasNext()){
//			Object[] o = (Object[]) i.next();
//			for (int j = 0; j < o.length; j++) {
//				System.out.println("Result==================="+o[j]);
//			}
//			
//			i.next();
//		}
//	}

	@Override
	public List<Balance> getUserByName() {
		// TODO Auto-generated method stub
		 return em.createNativeQuery("select balance.Sum, balance.Description, categorietype.Name" +
		 		" from balance, categorietype where balance.UserID = 1 and categorietype.UserID = 1 ;").getResultList();
		
	}

	@Override
	public List getSome() {
		// TODO Auto-generated method stub
		
		return em.createNativeQuery("findLastFiveTransaction", "BalanceWithCategoryType" ).getResultList();
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("getAll").getResultList();
	}
	

//	@Override
//	public List<Balance> getUserTransaction() {
//		// TODO Auto-generated method stub
//		return em.createNativeQuery("findLastFiveTransaction").getResultList();
//	}

}
