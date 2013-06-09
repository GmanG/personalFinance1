package ua.home.model;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserEJBLocal {
	User getUserByEmail(String email);
	 List<User> getUserByEmail1(String email);
	 public User userCheck(String email) throws Exception;
	 List<User> getUsers();
}
