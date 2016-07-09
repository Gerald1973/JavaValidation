package com.smilesmile1973;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.smilesmile1973.beans.Customer;
import com.smilesmile1973.beans.Delivery;

/**
 * Execution class
 * 
 * @author Gérald Maréchal
 *
 */
public final class RunMe {

	/**
	 * Print the messages on the console
	 * 
	 * @param violations
	 */
	public static <T> void displayMessages(Set<ConstraintViolation<T>> violations) {
		for (final ConstraintViolation<?> constraintViolation : violations) {
			System.out.println(constraintViolation.getMessage());
		}
	}

	/**
	 * Entry point
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		final Validator validator = factory.getValidator();
		// Beans initialisations
		final Delivery delivery = new Delivery();
		delivery.setArrivalTime(new Date());
		delivery.setArrivalTime(new Date());
		delivery.setCustomer(new Customer());
		delivery.getCustomer().setLastName("O");
		delivery.getCustomer().setFirstName("Gérald");

		final Set<ConstraintViolation<Delivery>> violations = validator.validate(delivery);
		displayMessages(violations);
	}

	private RunMe() {
	}
}
