package com.smilesmile1973.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.smilesmile1973.validators.group.GroupCar;

/**
 * This class symbolize a car used for the transportation
 * @author Gérald Maréchal
 *
 */
public class Car {
	/**
	 * The plate number of the car.
	 */
	@NotNull(message="{Car.plateNumber.NotNull}",groups=GroupCar.class)
	@Size(min=6,max=6,message="{Car.plateNumber.Size}",groups=GroupCar.class)
	private String plateNumber;

	/**
	 * @return the plateNumber
	 */
	public String getPlateNumber() {
		return plateNumber;
	}

	/**
	 * @param plateNumber the plateNumber to set
	 */
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
}
