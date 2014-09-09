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
	
	public UserDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User get(Long id){
		return null;
	}
	
	public List<User> getAll(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			//Step 1 Get a connection
			connection = DriverManager.getConnection(URI,USER,PASSWORD);
			
			//Step 2 Create a Statement (query)
			statement = connection.createStatement();
			
			//Step 3 Execute and Get Results
			resultSet = statement.executeQuery("SELECT * FROM user");
			
			List<User> users = new ArrayList<>();
			
			while(resultSet.next()){
				User user = User.builder()
						.id(resultSet.getLong("id"))
						.firstName(resultSet.getString("first_name"))
						.lastName(resultSet.getString("last_name"))
						.build();
				users.add(user);
			}
			
			
			statement.close();
			
			
			connection.close();
			
			return users;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeObjects(connection, statement, resultSet);
		}
		
		return null;
		
	}

	private void closeObjects(Connection connection, Statement statement,
			ResultSet resultSet) {
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Step 4 Close Statement
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Step 5 Close connection
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
