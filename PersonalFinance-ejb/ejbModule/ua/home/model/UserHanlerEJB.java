package ua.home.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ua.home.entity.User;

import com.sun.org.apache.xpath.internal.operations.Gte;

/**
 * Session Bean implementation class UserEJB
 */
@Stateless
@LocalBean
public class UserHanlerEJB implements UserHanlerEJBLocal {
	@PersistenceContext (unitName ="ModelJPA")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public UserHanlerEJB() {
        // TODO Auto-generated constructor stub
    }
    	
	private List<User> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("User.findUserByEmail").setParameter("email", email).getResultList();
	}
	
	@Override
	public User userCheck(String email) throws Exception{
		List<User> user = getUserByEmail(email);
		if(user.size()!=1)
			new Exception("=============== No user---------------------");
		return user.get(0);
	}

//	@Override
	private List<User> userLogin(String email, String pass) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("User.findUserByEmailAndPass").setParameter("email", email).setParameter("pass", pass).getResultList();
	}

	@Override
	public User userCheckLogin(String email, String pass) throws Exception{
		// TODO Auto-generated method stub
		List<User> user = userLogin(email, pass);
		if(user.size() != 1)
			new Exception("User not exist");
		
		return user.get(0);
	}
	
	
	
//	@Override
//	public List<User> getUsers() {
//		// TODO Auto-generated method stub
//		return em.createNamedQuery("getUsers").getResultList();
//	}

}
