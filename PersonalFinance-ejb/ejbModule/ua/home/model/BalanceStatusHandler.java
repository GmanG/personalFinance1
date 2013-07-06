package ua.home.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ua.home.entity.Balancestatus;

/**
 * Session Bean implementation class BalanceStatusHandler
 */
@Stateless
@LocalBean
public class BalanceStatusHandler implements BalanceStatusHandlerLocal {
	@PersistenceContext (unitName ="ModelJPA")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public BalanceStatusHandler() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Balancestatus getStatusByName(String status) {
		// TODO Auto-generated method stub
		return ((Balancestatus)em.createNamedQuery("Balancestatus.getName").setParameter("status", status).getSingleResult());
	}

}
