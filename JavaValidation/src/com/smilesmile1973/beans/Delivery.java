package com.smilesmile1973.beans;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Gérald Maréchal
 *
 */
public class Delivery {
	/**
	 * The {@link #arrivalTime} has to be > to {@link #timeOut}
	 */
	private Date arrivalTime;

	/**
	 * @see Customer
	 */
	@Valid
	@NotNull(message="{Delivery.customer.NotNull}")
	private Customer customer;
	
	@Valid
	@NotNull(message="{Delivery.car.NotNull}")
	private Car car;

	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}

	/**
	 * The {@link #timeOut} to be < {@link #arrivalTime}
	 */
	@NotNull(message = "{Delivery.timeOut.NotNull}")
	private Date timeOut;

	/**
	 * @return the arrivalTime
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the timeOut
	 */
	public Date getTimeOut() {
		return timeOut;
	}

	/**
	 * @param arrivalTime
	 *            the arrivalTime to set
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param timeOut
	 *            the timeOut to set
	 */
	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}
}