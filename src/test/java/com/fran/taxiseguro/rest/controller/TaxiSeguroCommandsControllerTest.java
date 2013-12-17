package com.fran.taxiseguro.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import com.fran.taxiseguro.domain.Account;
import com.fran.taxiseguro.services.TaxiSeguroService;

public class TaxiSeguroCommandsControllerTest {
	MockMvc mockMvc;
	
	@InjectMocks
	private TaxiSeguroCommandsController controller = new TaxiSeguroCommandsController();
	
	@Mock
	private TaxiSeguroService taxiSeguroService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		this.mockMvc = standaloneSetup(controller).setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
	}
	
	@Test
	public void thatTaxiCreateUserHttpOk() throws Exception {
		String PHONE_NUMBER = "123456789";
	    when(taxiSeguroService.getOrCreateAccount(PHONE_NUMBER)).thenReturn(accountCreated(UUID.fromString("f3512d26-72f6-4290-9265-63ad69eccc13")));

	    this.mockMvc.perform(
	            post("/taxiseguro/user")
	                    .accept(MediaType.APPLICATION_JSON)
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content("{\"phonenumber\":"+ PHONE_NUMBER+"}"))
	            .andDo(print())
	            .andExpect(status().isCreated());
	  }

	private Account accountCreated(UUID fromString) {
		Account account = new Account();
		account.setId(fromString.toString());
		return account;
	}
}
