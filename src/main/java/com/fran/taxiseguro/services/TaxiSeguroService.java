package com.fran.taxiseguro.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.fran.taxiseguro.domain.Account;
import com.fran.taxiseguro.domain.TaxiJourney;

@Repository
public class TaxiSeguroService {
	@Autowired
	private MongoTemplate mongoTemplate;
	     
	public static final String COLLECTION_ACCOUNTS = "accounts";
	public static final String COLLECTION_TAXIJOURNEYS = "taxiJourney";
	     
	public void addTaxiJourney(TaxiJourney taxiJourney) {
		if (!mongoTemplate.collectionExists(TaxiJourney.class)) {
			mongoTemplate.createCollection(TaxiJourney.class);
		}       
		taxiJourney.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(taxiJourney, COLLECTION_TAXIJOURNEYS);
	}
	
	/**
	 * Method to registry the account of a new user
	 * @param account
	 */
	public Account getAccount(String phone){
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		Query query = new Query(Criteria.where("phone").is(phone));
		Account account = mongoTemplate.findOne(query, Account.class);
		
		if(account == null){
			account = createNewAccount(phone);
		}
		return account;
	}
	
    private Account createNewAccount(String phone) {
		Account account = new Account();
		account.setPhonenumber(phone);
		account.setId(UUID.randomUUID().toString());
		return account;
	}

	public List<TaxiJourney> listTaxiStart() {
        return mongoTemplate.findAll(TaxiJourney.class, COLLECTION_TAXIJOURNEYS);
    }
	 
}
