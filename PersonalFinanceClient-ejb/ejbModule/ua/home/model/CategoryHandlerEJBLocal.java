package ua.home.model;

import java.util.List;

import javax.ejb.Local;

import ua.home.entity.Category;
import ua.home.entity.User;

@Local
public interface CategoryHandlerEJBLocal {

	List<Category> getCategoryByUser(User user);
	List<Category> getCategoryByUser1();
	Category getCategoryByName(String name);
	
}
