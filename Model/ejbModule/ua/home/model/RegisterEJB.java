package ua.home.model;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class RegisterEJB
 */
@Stateless
@LocalBean
public class RegisterEJB implements RegisterEJBLocal {
	@PersistenceContext(unitName = "ModelJPA")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public RegisterEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void userRegister(String email, String password) {
		User user = new User(); 
		user.setEmail(email);
		user.setPass(password);
		user.setCreated(new Date());
		user.setUpdated(new Date());
//		user.setIP(ip);
		try {
			em.merge(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("=============================================="+e);
		}
	}

}
