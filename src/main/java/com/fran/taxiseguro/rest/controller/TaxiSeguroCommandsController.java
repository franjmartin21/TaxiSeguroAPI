package com.fran.taxiseguro.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.fran.taxiseguro.domain.Account;
import com.fran.taxiseguro.services.TaxiSeguroService;

@Controller
@RequestMapping("/taxiseguro")
public class TaxiSeguroCommandsController {
	
	private static Logger LOG = LoggerFactory.getLogger(TaxiSeguroCommandsController.class);

	@Autowired
    private TaxiSeguroService taxiSeguroService;
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
    public ResponseEntity<Account> getOrRegistryUser(@RequestBody Account account, UriComponentsBuilder builder) {
		HttpStatus status;
		HttpHeaders headers = new HttpHeaders();
		
		account = taxiSeguroService.getOrCreateAccount(account.getPhonenumber());
		if (account != null){
			//response = AccountCreationResponses.ACCOUNT_CREATED; 
			headers.setLocation(
	                builder.path("/taxiseguro/user/{id}")
	                        .buildAndExpand(account.getId().toString()).toUri());
			status = HttpStatus.CREATED; 
		}
		else{
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Account>(account, headers, status);
	}
	
	@RequestMapping(value="/{clientid}/startTaxi", method = RequestMethod.POST)
    public ResponseEntity<Account> createOrder(@PathVariable String id, @RequestBody String plate) {
		Account  account= new Account();
		HttpHeaders headers = new HttpHeaders();	
		
		return new ResponseEntity<Account>(account, headers, HttpStatus.CREATED);
	}
	
	
	
}
