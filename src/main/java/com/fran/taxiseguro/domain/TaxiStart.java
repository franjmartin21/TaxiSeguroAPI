package com.fran.taxiseguro.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class TaxiStart {
	@Id
	private String id;
	
	private String phoneNumber;
	
	private Date dateStart;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	@Override
	public String toString() {
		return "TaxiStart [id=" + id + ", phoneNumber=" + phoneNumber
				+ ", dateStart=" + dateStart + "]";
	}
	
	
	
	
}
