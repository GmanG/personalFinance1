package ua.home.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class LoginEJB
 */
@Stateless
@LocalBean
public class LoginEJB implements LoginEJBLocal {
	@PersistenceContext (unitName = "ModelJPA")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public LoginEJB() {
        // TODO Auto-generated constructor stub
    }

	
	private List<User> userLogin(String email, String pass) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findUserByEmailAndPass").setParameter("email", email).setParameter("pass", pass).getResultList();
	}

	@Override
	public User userCheckLogin(String email, String password) throws Exception{
		// TODO Auto-generated method stub
		List<User> user = userLogin(email, password);
		if (user.size() != 1){
			new Exception("Incorect login or pass");
		}
		return user.get(0);
	}

}
