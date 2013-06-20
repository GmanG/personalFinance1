package ua.home.model;

import java.util.List;

import javax.ejb.Local;

import ua.home.entity.User;

@Local
public interface UserHanlerEJBLocal {

//	 List<User> getUserByEmail1(String email);
//	public List<User> userLogin(String email, String pass);
	public User userCheckLogin(String email, String pass) throws Exception;
	public User userCheck(String email) throws Exception;
	 
//	 List<User> getUsers();
	
}
