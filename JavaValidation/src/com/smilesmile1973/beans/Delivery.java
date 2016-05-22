package com.smilesmile1973.beans;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Delivery {
	/**
	 * The {@link #arrivalTime} has to be > to {@link #timeOut}
	 */
	
	private Date arrivalTime;

	/**
	 * The client number needs to have at less 5 character
	 */
	@NotNull(message="{validation.clientNumber.notNull}")
	private String clientNumber;

	/**
	 * The {@link #timeOut} to be < {@link #arrivalTime}
	 */
	@NotNull(message="{validation.delivery.timeout.notNull}")
	private Date timeOut;

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}
}
