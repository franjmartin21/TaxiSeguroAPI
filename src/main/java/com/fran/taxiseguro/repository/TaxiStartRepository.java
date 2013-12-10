package com.fran.taxiseguro.repository;

import java.util.List;

import com.fran.taxiseguro.domain.TaxiJourney;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TaxiStartRepository extends MongoRepository<TaxiJourney, String>{
	public List <TaxiJourney> findByPhoneNumber();
}
