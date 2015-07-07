package com.spring.project.feedback.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PHONENO_PATTERN="((\\+*)((0[ -]+)*|(91 )*)(\\d{12}+|\\d{10}+))|\\d{5}([- ]*)\\d{6}";
	private static Pattern pattern;
	private static Matcher matcher;

	 

			
		
	public static boolean emailValidate(String emailId) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher=pattern.matcher(emailId);
		return matcher.matches();
		
	}





	public static boolean phoneNoValidate(String phoneNo) {
		pattern = Pattern.compile(PHONENO_PATTERN);
		matcher=pattern.matcher(phoneNo);
		return matcher.matches();
	}
}
