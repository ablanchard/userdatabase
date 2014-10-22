package fr.epf.userdatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epf.userdatabase.dao.UserDAO;
import fr.epf.userdatabase.domain.User;

@Service
public class UserDBService {
	
	@Autowired
	private UserDAO userDAO;
	
	
	public void create(User user){
		userDAO.create(user);
	}
		
	public List<User> getAll(){
		return userDAO.getAll();
	}

}
