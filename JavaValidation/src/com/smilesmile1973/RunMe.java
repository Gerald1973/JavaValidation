package com.smilesmile1973;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import com.smilesmile1973.beans.Car;
import com.smilesmile1973.beans.Customer;
import com.smilesmile1973.beans.Delivery;
import com.smilesmile1973.validators.DeliveryOrderValidation;
import com.smilesmile1973.validators.group.GroupCar;
import com.smilesmile1973.validators.group.GroupCustomer;

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
		System.out.println("====================================================");
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
		delivery.setCar(new Car());
		delivery.setTimeOut(new Date());

		Set<ConstraintViolation<Delivery>> violations = validator.validate(delivery, DeliveryOrderValidation.class);
		displayMessages(violations);

		violations = validator.validate(delivery, GroupCar.class, GroupCustomer.class, Default.class);
		displayMessages(violations);
	}

	private RunMe() {
	}
}
