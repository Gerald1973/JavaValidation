package com.smilesmile1973.validators;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import com.smilesmile1973.validators.group.GroupCar;
import com.smilesmile1973.validators.group.GroupCustomer;

@GroupSequence({Default.class,GroupCustomer.class,GroupCar.class})
public interface DeliveryOrderValidation {

}
