package com.demo.dataJPA.dataJpaIntro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dataJpa.Dao.daoImpl;
import com.dataJpa.Dao.employeeDao;
import com.dataJpaExample.entity.employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	AnnotationConfigApplicationContext container=new AnnotationConfigApplicationContext(AppConfig.class);
    	//This container will scans/searches for all the beans that are registered in this application.
    	//For that, we need to mention the configuration file  i.e, AppConfig.class

    	employeeDao repo=container.getBean(employeeDao.class);
    	
    	
    	employee emp=new employee();

    //	emp.setId(45);  -- no need to supply this input, since it can be auto-incremented
    	// modify the Id column in the database accordingly
    	//alter table employee modify empId int AUTO_INCREMENT
    	emp.setName("Harish");
    	
    	//To save this 'emp' object into the database , we use entityManager.persist() method
    	
    	//employeeDao repo=new daoImpl();  // we should not be practising by creating the object directly
    	//instead we should have to maintain the spring container to do that i.e, called Spring IOC using ApplicationContext or 
    	//any other sub interfaces of it. lets just going for AnnotationConfigApplicationContext this time.
    	//repo.saveEmployee(emp);
    	
    	repo.saveEmployee(emp);
    
    	
    }
}
