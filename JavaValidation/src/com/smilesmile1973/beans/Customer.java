package com.smilesmile1973.beans;

import javax.validation.constraints.NotNull;

public class Customer {
	private String adresse;
	/**
	 * Not null
	 */
	@NotNull
	private String firstName;
	/**
	 * 
	 */
	@NotNull
	private String lastName;
}
