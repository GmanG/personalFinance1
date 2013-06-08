package ua.home.model;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LoginEJBLocal {

	
	User userCheckLogin(String email, String password) throws Exception;
	User userCheck(String email) throws Exception;
}
