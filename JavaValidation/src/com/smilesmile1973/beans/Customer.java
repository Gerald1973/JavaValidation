package com.smilesmile1973.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	
	private String adresse;
	
	@NotNull(message="{Customer.clientNumber.NotNull}")
	private String clientNumber;
	/**
	 * Not null
	 */
	@NotNull
	private String firstName;
	/**
	 * 
	 */
	@NotNull
	@Size(min=2,max=30,message="{Customer.lastName.Size}")
	private String lastName;
	public String getClientNumber() {
		return clientNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
