package ua.home.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ua.home.entity.Typecategory;
import ua.home.entity.User;

/**
 * Session Bean implementation class CategoryTypeEJB
 */
@Stateless
@LocalBean
public class TypeCategoryHandlerEJB implements TypeCategoryHandlerEJBLocal {
	@PersistenceContext (unitName = "ModelJPA")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public TypeCategoryHandlerEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Typecategory userRelativeCategoryType(User user) {
		return ((Typecategory)em.createNamedQuery("getCategoryTypeByUser").setParameter("user", user).getResultList());
	}

	@Override
	public Typecategory getCategoryTypeByName(String name) {
		return ((Typecategory)em.createNamedQuery("Typecategory.getOneTypeByName").setParameter("name", name).getSingleResult());
	}

	@Override
	public List<Typecategory> getAllTypeCategory(User user) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Typecategory.getAllTypeCategoryUser").setParameter("user", user).getResultList();
	}

}
