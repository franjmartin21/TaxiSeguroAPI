package com.fran.taxiseguro;
 
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.fran.taxiseguro.config.SpringMongoConfig;
import com.fran.taxiseguro.domain.TaxiJourney;
 

//import org.springframework.context.support.GenericXmlApplicationContext;
 
public class App {
 
    public static void main(String[] args) {
 
	// For XML
	//ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
 
	// For Annotation
	ApplicationContext ctx = 
             new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
 
	TaxiJourney taxiStart = new TaxiJourney();
	taxiStart.setId("1");
	taxiStart.setDateStart(new Date());
	//taxiStart.setPhoneNumber("321654987");
	
 
	// save
	mongoOperation.save(taxiStart);
 
	// now user object got the created id.
	System.out.println("1. taxiStart : " + taxiStart);
 
	// query to search user
	Query searchTaxiStartQuery = new Query(Criteria.where("phoneNumber").is("321654987"));
 
	// find the saved user again.
	TaxiJourney savedTaxiStart = mongoOperation.findOne(searchTaxiStartQuery, TaxiJourney.class);
	System.out.println("2. find - savedTaxiStart : " + savedTaxiStart);
 
	// update password
	mongoOperation.updateFirst(searchTaxiStartQuery, 
                         Update.update("date", new Date()),TaxiJourney.class);
 
	// find the updated user object
	TaxiJourney updatedTaxiStart = mongoOperation.findOne(searchTaxiStartQuery, TaxiJourney.class);
 
	System.out.println("3. updatedTaxiStart : " + updatedTaxiStart);
 
	// delete
	//mongoOperation.remove(searchTaxiStartQuery, TaxiStart.class);
 
	// List, it should be empty now.
	List<TaxiJourney> listTaxiStart = mongoOperation.findAll(TaxiJourney.class);
	System.out.println("4. Number of taxiStart = " + listTaxiStart.size());
 
    }
 
}

