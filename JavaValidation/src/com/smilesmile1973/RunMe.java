package com.smilesmile1973;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.smilesmile1973.beans.Delivery;

public class RunMe {
	public static void main(String[] args){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		//Beans initialisations
		Delivery delivery = new Delivery();
		delivery.setArrivalTime(new Date());
		delivery.setClientNumber("12313546544");
		delivery.setArrivalTime(new Date());
		Set<ConstraintViolation<Delivery>> violations = validator.validate(delivery);
		displayMessages(violations);
	}
	
	public static <T> void displayMessages(Set<ConstraintViolation<T>> violations){
		for (ConstraintViolation<?> constraintViolation : violations) {
			System.out.println(constraintViolation.getMessage());
		}
	}
}
