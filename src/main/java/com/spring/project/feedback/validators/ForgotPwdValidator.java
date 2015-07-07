package com.spring.project.feedback.validators;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.project.feedback.form.RegistrationForm;

public class ForgotPwdValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		RegistrationForm reg = (RegistrationForm) target;
		System.out.println("in validator" + reg);

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"required.name");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empid",
				"required.empid");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer",
				"required.answer");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "question",
				"required.question");

	}

}
