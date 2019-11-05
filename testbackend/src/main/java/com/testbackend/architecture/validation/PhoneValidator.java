package com.testbackend.architecture.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private Pattern regex = Pattern.compile("\\+\\d{12}");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Matcher m = regex.matcher(value);
		return m.matches();
	}

}
