package ua.home.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ua.home.entity.Category;
import ua.home.entity.User;

/**
 * Session Bean implementation class CategoryEJB
 */
@Stateless
@LocalBean
public class CategoryHandlerEJB implements CategoryHandlerEJBLocal {
	@PersistenceContext (unitName = "ModelJPA")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public CategoryHandlerEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Category> getCategoryByUser(User user) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllUserCategory").setParameter("user", user).getResultList();
	}

	@Override
	public Category getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return ((Category)em.createNamedQuery("findOneCategoryBYID").setParameter("name", name).getSingleResult());
	}

	@Override
	public List<Category> getCategoryByUser1() {
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
