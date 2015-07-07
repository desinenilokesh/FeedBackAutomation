/*package com.spring.project.feedback.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.project.feedback.form.RegistrationForm;

public class PasswordValidator1 implements
		ConstraintValidator<PwdEquals, String> {
	@Autowired
	private RegistrationForm regform;

	@Override
	public void initialize(PwdEquals constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		// return false;
		if (regform == null) {
			return true;

		} else {
			System.out.println(regform);
			if (regform.getPassword().equals(regform.getConfirmpwd())) {
				return true;
			} else
				return false;

		}
	}

}
*/