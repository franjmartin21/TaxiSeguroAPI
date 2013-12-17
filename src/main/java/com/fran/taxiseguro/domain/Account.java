package com.fran.taxiseguro.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Account {
	/**
	 * How to identify a user
	 * How to give a number to send the google message?
	 * Should I store the data of the phone?
	 */
	@Id
	private String id;
	
	private String phonenumber;
	
	private Date createdDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
