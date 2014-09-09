package fr.epf.userdatabase.service;

import java.util.List;

import fr.epf.userdatabase.dao.UserDAO;
import fr.epf.userdatabase.domain.User;

public class UserDBService {
	
	private UserDAO userDAO = new UserDAO();
	
	public User get(Long id){
		return userDAO.get(id);
	}
	
	public List<User> getAll(){
		return userDAO.getAll();
	}

}
