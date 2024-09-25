package com.dataJpa.DbConfigurations;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
public class dbConfig {
	
	//CONNECTION ESTABLISHMENT

	//To establish the connection to our database, we need to setup the connection through this 
	//configuration 'dbconfig' class.
	//include spring -orm dependency for this item.
	
	//we need to create a bean for 'DriverManagerDataSource' because its holding url,username and password config details.
	//do ctrl+shift+t to view the implementation.
	//But it will not create any connection pool, that is why it is not encouraged to use in the production purposes.
	
	@Bean
	public DataSource dataAccessSource()
	{
		DriverManagerDataSource obj=new DriverManagerDataSource();
		obj.setUrl("jdbc:mysql://localhost:3306/sampledb");
		obj.setUsername("root");
		obj.setPassword("root");
		
		return obj;
	}
	
	
	//------------------------------------------------------------------------------------------
	
	
	//creating EntityManagerFactory bean
	
	
	// to create a bean of entitymanagerFactory , we need to create a bean for 
	//'LocalContainerEntityManagerFactoryBean' which in turn creates the bean for 'EntityManagerFactory'
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emBean()
	{
		
		
		LocalContainerEntityManagerFactoryBean obj= new LocalContainerEntityManagerFactoryBean();
		obj.setDataSource(dataAccessSource()); // Telling this is the connection you have to use.
		obj.setPackagesToScan("com.dataJpaExample.entity");   // we have to mention the entity's package to scan here
		obj.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); // we have to provide vendor for JPA -- NoPersistenceProvider error Arised
		obj.setPersistenceUnitName("mysqldb");   // INFO: Initialized JPA EntityManagerFactory for persistence unit 'mysqldb'
		//The above line indicates which persistent unit needs to be initialized if there are multiple databases present in the
		//application.
		return obj;
	}
	
	//Creating transactionManager bean to ensuring the safe transaction within the database.
	
	
	@Bean
	public PlatformTransactionManager tmanager(EntityManagerFactory emf)
	{
		JpaTransactionManager jTransaction=new JpaTransactionManager();
		jTransaction.setEntityManagerFactory(emf);
		
		return  jTransaction;
	}
	
	//------------------------------------------------------------------------------------------


}
