package ua.home.model;

import java.util.List;

import javax.ejb.Local;

import ua.home.entity.Typecategory;
import ua.home.entity.User;

@Local
public interface TypeCategoryHandlerEJBLocal {
	
	Typecategory userRelativeCategoryType(User user);
	Typecategory getCategoryTypeByName(String name);
	List<Typecategory> getAllTypeCategory(User user);

}
