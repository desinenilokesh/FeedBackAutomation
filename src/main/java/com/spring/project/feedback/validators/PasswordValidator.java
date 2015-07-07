package com.spring.project.feedback.validators;


import java.util.regex.Pattern;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.project.feedback.form.RegistrationForm;

@Primary
@Component("pvalidator")
public class PasswordValidator implements Validator {

	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return RegistrationForm.class.isAssignableFrom(clazz);
		
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		RegistrationForm reg=(RegistrationForm)target;
		System.out.println("in validator"+reg);
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password");
	 
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmpwd",
					"required.confirmPassword");
	/*		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "technologies",
					"required.technologies");*/
			if(reg.getEmpid()==null || reg.getEmpid().isEmpty())
			{
				errors.rejectValue("empid", "regbean.empid", "please enter id");
				//errors.reject("id","id.required");
			}
	/*		boolean b=reg.getPassword().equals(reg.getConfirmpwd());
			System.out.println("in validator"+b);*/
					
	 
		if(!(reg.getPassword().equals(reg.getConfirmpwd())))
		{
			errors.rejectValue("confirmpwd", "regbean.confirmpwd", "password,confirm didn't matched");
			//errors.reject("password","nomatch.password");
		}
	//	String special = "[A-Z][0-9]!@#$%^&*()_";
		String pattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#*$%]).{6,20})";
		if(!(reg.getPassword().matches(pattern)))
		{
			errors.rejectValue("password", "regbean.password","password should have atleast one spl char & one upper case and lower case char and one digit and length should be 6 -20");
		}
		
	}
	

}
