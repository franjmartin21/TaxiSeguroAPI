package com.fran.taxiseguro.domain;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;

public class TaxiJourney {
	@Id
	private String id;
	
	private Date dateStart;
	
	private Date endDate;
	
	private String plate;
	
	private String accountId;
	
	public TaxiJourney(){
		
	}
	
	public TaxiJourney(String plate, String accountId){
		this.id=UUID.randomUUID().toString();
		this.dateStart = new Date();
		this.plate=plate;
		this.accountId = accountId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
