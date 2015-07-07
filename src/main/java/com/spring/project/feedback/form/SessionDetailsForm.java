package com.spring.project.feedback.form;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class SessionDetailsForm {
	private String sessionid;
	private String empid;

	@NotEmpty
	private String rating[]=new String[7];
	

	private String suggestions;
	
	public String getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}
	
	public String[] getRating() {
		return rating;
	}
	public void setRating(String[] rating) {
		this.rating = rating;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	

	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	@Override
	public String toString() {
		return "SessionDetailsForm [sessionid=" + sessionid + ", empid="
				+ empid + ", rating=" + Arrays.toString(rating)
				+ ", suggestions=" + suggestions + "]";
	}

	
	
	

}
