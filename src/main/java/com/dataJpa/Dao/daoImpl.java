package com.dataJpa.Dao;

import org.springframework.stereotype.Repository;

import com.dataJpaExample.entity.employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class daoImpl implements employeeDao  {
	
	@PersistenceContext(unitName="mysqldb")
	EntityManager entityManager;  // spring was unable to get a bean of type entityManager,
	//throws UnsatisfiedDependencyException
	//This obj is coming from 'EntityManagerFactory' class, therefore, we need to take care of this first.
	//To create 'entityManagerFactory', 'LocalContainerEntityManagerFactoryBean'  --helps us to create the bean of
	//EntityManagerFactory
	// and this is a spring's bean, therefore, we need to include the dependency: 'spring-orm'
	//and we have to create a bean for this 'LocalContainerEntityManagerFactoryBean'

	@Transactional
	public void saveEmployee(employee empObj) {
		
		// To save the 'empObj' we should have to make use of entityManager(JPA) // to session in Hibernate

		entityManager.persist(empObj);
		System.out.println("record inserted!!!");
		
	}

}
