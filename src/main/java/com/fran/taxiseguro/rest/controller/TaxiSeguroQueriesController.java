package com.fran.taxiseguro.rest.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fran.taxiseguro.domain.Account;
import com.fran.taxiseguro.domain.TaxiJourney;
import com.fran.taxiseguro.services.TaxiSeguroService;

@Controller
@RequestMapping("/taxiseguro")
public class TaxiSeguroQueriesController {

    private static Logger LOG = LoggerFactory.getLogger(TaxiSeguroQueriesController.class);

    @Autowired
    private TaxiSeguroService taxiSeguroService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TaxiJourney> getAllTaxiSeguro() {
    	List<TaxiJourney> taxiStartList = new ArrayList<TaxiJourney>();
        taxiStartList = taxiSeguroService.listTaxiStart();
        return taxiStartList;
    }
    
    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Account> getUserById(@PathVariable String id) {
    	Account account = null;
        account = taxiSeguroService.getAccount(id);
        if (account == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

}