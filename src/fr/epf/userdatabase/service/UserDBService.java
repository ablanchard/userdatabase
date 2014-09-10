package fr.epf.userdatabase.service;

import java.util.List;

import fr.epf.userdatabase.dao.UserDAO;
import fr.epf.userdatabase.domain.User;

public class UserDBService {
	
	private static UserDBService instance = null ;
	
	//static to be call without an instance
	public static UserDBService getInstance(){
		
		if(instance == null){
			//If there is no instance yet just created it.
			instance = new UserDBService();
		} 
		return instance;
	}
	
	private UserDBService(){
		
	}
	
	private UserDAO userDAO = UserDAO.getInstance();
	
	public User get(Long id){
		return null; //userDAO.get(id);
	}
	
	public List<User> getAll(){
		return userDAO.getAll();
	}

}
