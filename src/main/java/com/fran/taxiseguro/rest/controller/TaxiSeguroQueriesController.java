package com.fran.taxiseguro.rest.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fran.taxiseguro.domain.TaxiStart;
import com.fran.taxiseguro.services.TaxiSeguroService;

@Controller
@RequestMapping("/taxistart")
public class TaxiSeguroQueriesController {

    private static Logger LOG = LoggerFactory.getLogger(TaxiSeguroQueriesController.class);

    @Autowired
    private TaxiSeguroService taxiSeguroService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TaxiStart> getAllTaxiSeguro() {
    	List<TaxiStart> taxiStartList = new ArrayList<TaxiStart>();
        taxiStartList = taxiSeguroService.listTaxiStart();
    	/*TaxiStart t = new TaxiStart();
    	t.setDateStart(new Date());
    	t.setId("1");
    	t.setPhoneNumber("234q234");
    	taxiStartList.add(t);*/
        return taxiStartList;
    }

}