package fr.epf.userdatabase.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import fr.epf.userdatabase.domain.User;

@Repository
public class UserDAO {
	

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("userdatabase-PU");
		
	
	public void create(User user){
		EntityManager em = null;
		try{
			em = getEntityManager();
			
			//Open a transaction because it's a write operation
			em.getTransaction().begin();
			
			//Save the user
			em.persist(user);
			
			//Really save in DB
			em.getTransaction().commit();
			
		} finally{
			if(em != null){
				em.close();
			}
		}
	}
	
	
	private EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public List<User> getAll(){
		EntityManager em = null;
		try {
			//Get Connection
			em = getEntityManager();
			
			//Fetch the results
			return em.createQuery("SELECT u FROM User u").getResultList();
		} finally {
			//Close the connection
			if(em != null){
				em.close();	
			}
		}
	}
}
