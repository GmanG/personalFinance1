package ua.home.model;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CategoryEJBLocal {

	Categorie getCategoryByUser(User user);
	Categorie getCategoryByName(String name);
}
