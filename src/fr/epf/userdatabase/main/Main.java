package fr.epf.userdatabase.main;

import java.util.List;

import fr.epf.userdatabase.dao.UserDAO;
import fr.epf.userdatabase.domain.User;
import fr.epf.userdatabase.service.UserDBService;
/**
 * Testing class
 * @author alex
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//Get a Service
		UserDBService userDBService = new UserDBService();
		
		//Get all users
		List<User> users = userDBService.getAll(); 
		
		//Show them
		System.out.println(users);
		

	}

}
