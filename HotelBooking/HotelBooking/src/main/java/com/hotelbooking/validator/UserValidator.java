package com.hotelbooking.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hotelbooking.pojo.User;

public class UserValidator implements Validator{

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
			 String ID_PATTERN = "[0-9]+";  
			 String MIX_PATTERN="[0-9a-zA-Z]+";
			 String STRING_PATTERN = "[a-zA-Z]+";  
			 String MOBILE_PATTERN = "[0-9]{10}";  
	@Override
	public boolean supports(Class aClass) {

		return aClass.equals(User.class);
	}

	 private Pattern pattern;  
	 private Matcher matcher;  
	  
	 
	  
	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		
		  if (!(user.getFirst_name() != null && user.getFirst_name().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(user.getFirst_name());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("first_name", "first_name.containNonChar",  
					      "Enter a valid name");  }
			   }
			   
		if (!(user.getLast_name() != null && user.getLast_name().isEmpty())) {  
				   pattern = Pattern.compile(STRING_PATTERN);  
				   matcher = pattern.matcher(user.getLast_name());  
				   if (!matcher.matches()) {  
				    errors.rejectValue("last_name", "last_name.containNonChar",  
				      "Enter a valid last name");  }}
				   
		if (!(user.getUsername() != null && user.getUsername().isEmpty())) {  
					   pattern = Pattern.compile(STRING_PATTERN);  
					   matcher = pattern.matcher(user.getUsername());  
					   if (!matcher.matches()) {  
					    errors.rejectValue("username", "username.containNonChar",  
					      "Enter a valid user name only alpha numneric allowed");  }}
		if (!(user.getEmail_Id() != null && user.getEmail_Id().isEmpty())) {  
						   pattern = Pattern.compile(EMAIL_PATTERN);  
						   matcher = pattern.matcher(user.getEmail_Id());  
						   if (!matcher.matches()) {  
						    errors.rejectValue("Email_Id", "Email_Id.incorrect",  
						      "Enter a correct email");  
						   }  }
						  
		 if (!(user.getPhone_number() != null && user.getPhone_number().isEmpty())) {  
			   pattern = Pattern.compile(MOBILE_PATTERN);  
			   matcher = pattern.matcher(user.getPhone_number());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("phone_number", "phone_number.incorrect",  
			      "Enter a correct phone number");  
			   }  }
			   
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name", "error.invalid.user", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", "error.invalid.user", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone_number", "error.invalid.user", "Phone Number Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Email_Id", "error.invalid.email.emailAddress","Email Required");
}
	}