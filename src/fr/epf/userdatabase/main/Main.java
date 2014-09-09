package fr.epf.userdatabase.main;

import java.util.ArrayList;
import java.util.List;

import fr.epf.userdatabase.domain.User;
/**
 * Testing class
 * @author alex
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//Declarating a list of 3 users
		List<User> users = new ArrayList<User>(3);
		
		//Use of default constructor
		User user1 = new User();
		user1.setId(1L);
		user1.setFirstName("John");
		user1.setLastName("Doe");
		
		//Add john doe to list
		users.add(user1);
		
		//Use of full constructor
		User user2 = new User(2L,"Alex","Blanchard");
		
		users.add(user2);
		
		//Use of the builder
		User user3 = User.builder()
				.firstName("Loic")
				.lastName("Ortola")
				.build();
		
		users.add(user3);
		
		//Show them
		System.out.println(users);
		

	}

}
