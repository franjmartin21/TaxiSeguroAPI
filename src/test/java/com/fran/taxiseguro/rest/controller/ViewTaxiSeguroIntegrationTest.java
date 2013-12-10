package com.fran.taxiseguro.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.test.web.servlet.MockMvc;

import com.fran.taxiseguro.domain.TaxiJourney;
import com.fran.taxiseguro.services.TaxiSeguroService;


public class ViewTaxiSeguroIntegrationTest {
	MockMvc mockMvc;
	
	@InjectMocks
	private TaxiSeguroQueriesController controller = new TaxiSeguroQueriesController();
	
	@Mock
	private TaxiSeguroService taxiSeguroService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		this.mockMvc = standaloneSetup(controller).setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
	}
	
	@Test
	public void thatTaxiStartHttpOk() throws Exception {
 
	    when(taxiSeguroService.listTaxiStart()).thenReturn(new ArrayList<TaxiJourney>());

	    this.mockMvc.perform(
	            get("/taxiseguro")
	                    .accept(MediaType.APPLICATION_JSON))
	            .andDo(print())
	            .andExpect(status().isOk());
	  }

}
