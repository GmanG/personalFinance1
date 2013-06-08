package ua.home.model;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CategoryTypeEJBLocal {
	
	Categorietype userRelativeCategoryType(User user);
	Categorietype getCategoryTypeByname(String name);

}
