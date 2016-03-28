package org.kelly_ann;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestJPA {
	
	public static void main(String[] args) {
		// Boilerplate Steps:
		// 1. create an entity mgr factory
		// 2. create an entity mgr
		// 3. create and entity transaction from the entity mgr
		// 4. start transaction
		// 5. persist entity mgr obj
		// 6. commit transaction
		// 7. close entity mgr obj
		
		//create the new employee obj that needs to be saved to the DB.
			//Employee employee1 = new Employee("Jeb", "Bush", "Governor", 900);
		
		// EntityManagerFactory is a helper obj used to create an entity mgr b/c 
		// an EntityManager is a complex obj that requires a lot of config.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeDB");
		EntityManager em = emf.createEntityManager();	//this is the key method in JPA
		
		//you need the EntityManager to get the specific transaction for that entity obj, then 
		// you can start the transaction via its begin() method.
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		
		// we call the persist() method to tell JPA that the obj provided needs to be persisted/saved to the DB, which
		// causes JPA to now mark this as a persisted object and will do the needed background work to
		// make sure this object is persisted to the DB.
		// commit() tell JPA to run a SQL INSERT statement to add the obj to the DB.
		// close() MUST be called explicitly even if you are using try-with-resources from Java 8.
			//em.persist(employee1);
		
		//print the employees in the table
		Query q = em.createQuery("select employee from Employee employee");	// using JPQL (Java Persistence Query Language)
		@SuppressWarnings("unchecked")
		List<Employee> results = q.getResultList();
		for (Employee employee : results) {
			System.out.println(employee);
		}
		
		
		trx.commit();
		em.close();
	}
}
