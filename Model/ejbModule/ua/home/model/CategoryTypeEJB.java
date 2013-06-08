package ua.home.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.xml.internal.stream.Entity;

/**
 * Session Bean implementation class CategoryTypeEJB
 */
@Stateless
@LocalBean
public class CategoryTypeEJB implements CategoryTypeEJBLocal {
	@PersistenceContext (unitName = "ModelJPA")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public CategoryTypeEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Categorietype userRelativeCategoryType(User user) {
		// TODO Auto-generated method stub
		return ((Categorietype)em.createNamedQuery("getCategoryTypeByUser").setParameter("user", user).getResultList());
	}

	@Override
	public Categorietype getCategoryTypeByname(String name) {
		// TODO Auto-generated method stub
		return ((Categorietype)em.createNamedQuery("getCategoryTypeByName").setParameter("name", name).getSingleResult());
	}

}
