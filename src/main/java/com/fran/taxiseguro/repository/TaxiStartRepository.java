package com.fran.taxiseguro.repository;

import java.util.List;

import com.fran.taxiseguro.domain.TaxiStart;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TaxiStartRepository extends MongoRepository<TaxiStart, String>{
	public List <TaxiStart> findByPhoneNumber();
}
