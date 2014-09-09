package fr.epf.userdatabase.main;

import java.util.List;

import fr.epf.userdatabase.dao.UserDAO;
import fr.epf.userdatabase.domain.User;
/**
 * Testing class
 * @author alex
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//Get a DAO
		UserDAO userDAO = new UserDAO();
		
		//Get all users
		List<User> users = userDAO.getAll(); 
		
		//Show them
		System.out.println(users);
		

	}

}
