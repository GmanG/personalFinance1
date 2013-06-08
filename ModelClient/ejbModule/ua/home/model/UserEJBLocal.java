package ua.home.model;

import javax.ejb.Local;

@Local
public interface UserEJBLocal {
	int getUserID(String email);
}
