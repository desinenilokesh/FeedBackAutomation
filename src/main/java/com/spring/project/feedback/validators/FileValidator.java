package com.spring.project.feedback.validators;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.spring.project.feedback.form.RegistrationForm;

@Component("fvalidator")
public class FileValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object regbean, Errors errors) {
		// TODO Auto-generated method stub
RegistrationForm reg=(RegistrationForm)regbean;
//String[] ext={"jpeg", "jpg", "png", "gif", "bmp"};
List<String> extensions = Arrays.asList("jpeg", "jpg", "png", "gif", "bmp","JPG");
String extension = "";
MultipartFile file=reg.getFile();
System.out.println("file name is"+file.getContentType());
String fileName=file.getContentType();
int i = fileName.lastIndexOf('/');
if (i > 0) {
    extension = fileName.substring(i+1);
}
System.out.println("Ext is"+extension);


if(reg.getFile().getSize()==0)
{
	errors.rejectValue("file", "regbean.selectfile", "please select a file");
	}
else if(!extensions.contains(extension))
{
	errors.rejectValue("file", "regbean.selectfile", "please select an image file");
	}
//reg.getFile().getSize() This will return size in bytes
else if(reg.getFile().getSize()>131072)
{
	errors.rejectValue("file", "regbean.selectfile", "please select an image below 256 kb");
	}
	}
	

}
