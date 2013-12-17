package com.fran.taxiseguro.domain.rest;

public class AccountCreationResponses {
	/*ACCOUNT_CREATED("Account created Successfully"),
	ACCOUNT_RECOVERED("Account recovered"),
	ERROR_CREATING_ACCOUNT("Error registering account"),
	FRIEND_ADDED("The friend was successfully Added"),
	FRIEND_REMOVED("The friend was removed"),
	FRIEND_DOES_NOT_EXIST("The friend is not registered");
	*/
	private String message;

	public AccountCreationResponses(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
