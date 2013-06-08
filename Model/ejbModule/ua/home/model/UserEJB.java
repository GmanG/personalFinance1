package ua.home.model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class UserEJB
 */
@Stateless
@LocalBean
public class UserEJB implements UserEJBLocal {
	@PersistenceContext (unitName ="ModelJPA")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public UserEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int getUserID(String email) {
		// TODO Auto-generated method stub
//		return em.createNamedQuery("getUserID").setParameter("email", email).getFirstResult();
//		User user = new User();
//		user.getEmail();
//		user.getId();
		return 0;
	}

}
