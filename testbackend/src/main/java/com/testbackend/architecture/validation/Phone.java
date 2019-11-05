package com.testbackend.architecture.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PhoneValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
	
	String message() default "Phone invalid required +xxxxxxxxxxxx";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default { };

}
