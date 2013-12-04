package com.fran.taxiseguro.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.fran.taxiseguro.domain.TaxiStart;

@Repository
public class TaxiSeguroService {
	 @Autowired
	 private MongoTemplate mongoTemplate;
	     
	 public static final String COLLECTION_NAME = "taxiStart";
	     
	 public void addTaxiStart(TaxiStart taxiStart) {
		 if (!mongoTemplate.collectionExists(TaxiStart.class)) {
			 mongoTemplate.createCollection(TaxiStart.class);
		 }       
		 taxiStart.setId(UUID.randomUUID().toString());
		 mongoTemplate.insert(taxiStart, COLLECTION_NAME);
	 }
	     
    public List<TaxiStart> listTaxiStart() {
        return mongoTemplate.findAll(TaxiStart.class, COLLECTION_NAME);
    }
	     
/*
	     
	    public void updatePerson(Person person) {
	        mongoTemplate.insert(person, COLLECTION_NAME);      
	    }
	    */
}
