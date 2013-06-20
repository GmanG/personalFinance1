package ua.home.model;

import javax.ejb.Local;

@Local
public interface UserRegisterEJBLocal {

	void userRegister(String email, String password);
}
