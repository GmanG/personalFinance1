package ua.home.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.org.apache.xpath.internal.operations.Gte;

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
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return ((User)em.createNamedQuery("getUserByEmail").setParameter("email", email).getResultList());
	}
	@Override
	public List<User> getUserByEmail1(String email) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("getUserByEmail").setParameter("email", email).getResultList();
	}
	@Override
	public User userCheck(String email) throws Exception{
		List<User> user = getUserByEmail1(email);
		if(user.size()!=1)
			new Exception("=============== No user---------------------");
		return user.get(0);
	}
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("getUsers").getResultList();
	}

}
