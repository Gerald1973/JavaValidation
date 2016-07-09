package com.smilesmile1973.beans;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Delivery {
	/**
	 * The {@link #arrivalTime} has to be > to {@link #timeOut}
	 */
	private Date arrivalTime;
	
	@Valid
	@NotNull
	private Customer customer;

	/**
	 * The {@link #timeOut} to be < {@link #arrivalTime}
	 */
	@NotNull(message="{Delivery.timeOut.NotNull}")
	private Date timeOut;

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}
}
