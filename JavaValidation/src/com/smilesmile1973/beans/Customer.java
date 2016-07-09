package com.smilesmile1973.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.smilesmile1973.validators.group.GroupCustomer;

/**
 * Class representing one customer.
 * 
 * @author Gérald Maréchal
 *
 */
public class Customer {

	/**
	 * Customer adress.
	 */
	private String adresse;

	/**
	 * Clientnumber.
	 */
	@NotNull(message = "{Customer.clientNumber.NotNull}", groups = GroupCustomer.class)
	private String clientNumber;

	/**
	 * Not null
	 */
	@NotNull(message = "{Customer.firstName.NotNull}", groups = GroupCustomer.class)
	private String firstName;

	/**
	 * 
	 */
	@NotNull
	@Size(min = 2, max = 30, message = "{Customer.lastName.Size}", groups = GroupCustomer.class)
	private String lastName;

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @return the clientNumber
	 */
	public String getClientNumber() {
		return clientNumber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @param clientNumber
	 *            the clientNumber to set
	 */
	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
