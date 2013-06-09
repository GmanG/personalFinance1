package ua.home.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class CategoryEJB
 */
@Stateless
@LocalBean
public class CategoryEJB implements CategoryEJBLocal {
	@PersistenceContext (unitName = "ModelJPA")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public CategoryEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Categorie> getCategoryByUser(User user) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllUserCategory").setParameter("user", user).getResultList();
	}

	@Override
	public Categorie getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return ((Categorie)em.createNamedQuery("findOneCategoryBYID").setParameter("name", name).getSingleResult());
	}

	@Override
	public List<Categorie> getCategoryByUser1() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllUserCategory1").getResultList();
	}

//	@Override
//	public List<Categorie> selectCategory() {
//		// TODO Auto-generated method stub
//		return em.createNamedQuery("findAllUserCategory").getResultList();
////		return List<Categorie>;
//	}

}
