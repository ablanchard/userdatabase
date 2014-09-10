package fr.epf.userdatabase.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.epf.userdatabase.domain.User;

public enum UserDAO {
	
	INSTANCE;
	
	DataSource ds;
	
	public static UserDAO getInstance(){
		return INSTANCE;
	}
	
	private UserDAO(){
		Context ctx;
		try {
			ctx = new InitialContext();
			//Lookup of the datasource named jdbc/jee-training in the JNDI directory
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/userdatabase-ds");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try { 
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User get(Long id){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {

			
			//Step 1 Get a connection
			connection = getConnection();
			
			//Step 2 Create a Statement (query)
			statement = connection.prepareStatement("SELECT * FROM user WHERE id=?");
			statement.setLong(1, id);
			
			//Step 3 Execute and Get Results
			resultSet = statement.executeQuery();
			
			User user = null ;
			
			
			if(resultSet.next()){
				user = User.builder()
						.id(resultSet.getLong("id"))
						.firstName(resultSet.getString("first_name"))
						.lastName(resultSet.getString("last_name"))
						.build();
			}
			
			
			statement.close();
			
			
			connection.close();
			
			return user;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeObjects(connection, statement, resultSet);
		}
		
		return null;
	}

	private Connection getConnection() {
		Connection connection = null;
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			
			System.err.println("Could not get a connection");
		}
		return connection;
	}
	
	public List<User> getAll(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			
			connection = getConnection();
			
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
