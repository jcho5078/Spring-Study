package com.jcho5078.mvc.validate.annotation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserRegValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegReq.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		
		System.out.print(errors);
	}
	
}
