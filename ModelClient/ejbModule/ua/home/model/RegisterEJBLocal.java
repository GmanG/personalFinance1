package ua.home.model;

import javax.ejb.Local;

@Local
public interface RegisterEJBLocal {

	void userRegister(String email, String password);
}
