package ua.home.model;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CategoryEJBLocal {

	List<Categorie> getCategoryByUser(User user);
	List<Categorie> getCategoryByUser1();
	Categorie getCategoryByName(String name);
}
