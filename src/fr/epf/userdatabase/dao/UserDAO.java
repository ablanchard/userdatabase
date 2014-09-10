package fr.epf.userdatabase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.epf.userdatabase.domain.User;

public enum UserDAO {
	
	INSTANCE;
	
	EntityManagerFactory emf;
	
	public static UserDAO getInstance(){
		return INSTANCE;
	}
	
	private UserDAO(){
		emf = Persistence.createEntityManagerFactory("userdatabase-PU");	
		
	}
	/*
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
*/
	private EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public List<User> getAll(){
		EntityManager em = null;
		try {
			em = getEntityManager();
			return em.createQuery("SELECT u FROM User u").getResultList();
		} finally {
			if(em != null){
				em.close();	
			}
		}
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
