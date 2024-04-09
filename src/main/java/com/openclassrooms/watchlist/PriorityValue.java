package com.openclassrooms.watchlist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriorityValue implements ConstraintValidator<Priority, String>{
	
	@Override
	public void initialize(Priority constraintAnnotation) {

		
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	
		return value.trim().length()==1 && "LHM".contains(value.trim());
	}

	


}