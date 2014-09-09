package fr.epf.userdatabase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.epf.userdatabase.domain.User;

public class UserDAO {
	
	private static final String URI = "jdbc:mysql://127.0.0.1:3306/jee-training";
	private static final String USER = "jee-training";
	private static final String PASSWORD = "password";
	
	
	public User get(Long id){
		return null;
	}
	
	public List<User> getAll(){
		Connection connection = null;
		try {

			//Step 1 Get a connection
			connection = DriverManager.getConnection(URI,USER,PASSWORD);
			
			//Step 2 Create a Statement (query)
			Statement statement = connection.createStatement();
			
			//Step 3 Execute and Get Results
			ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
			
			List<User> users = new ArrayList<>();
			
			while(resultSet.next()){
				User user = User.builder()
						.id(resultSet.getLong("id"))
						.firstName(resultSet.getString("first_name"))
						.lastName(resultSet.getString("last_name"))
						.build();
				users.add(user);
			}
			
			//Step 4 Close Statement
			statement.close();
			
			//Step 5 Close connection
			connection.close();
			
			return users;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
