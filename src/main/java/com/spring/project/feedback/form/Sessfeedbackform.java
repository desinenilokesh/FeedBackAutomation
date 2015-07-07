package com.spring.project.feedback.form;

public class Sessfeedbackform {
	
	private String empid;
	private int sesid;
	private int covcontent;
	private int matquality;
	private int prac;
	private int subknowl;
	private int clarity;
	private int responsive;
	private int arrangements;
	private String suggestions;
	private float eagg;

	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public int getSesid() {
		return sesid;
	}
	public void setSesid(int sesid) {
		this.sesid = sesid;
	}
	public int getCovcontent() {
		return covcontent;
	}
	public void setCovcontent(int covcontent) {
		this.covcontent = covcontent;
	}
	public int getMatquality() {
		return matquality;
	}
	public void setMatquality(int matquality) {
		this.matquality = matquality;
	}
	public int getPrac() {
		return prac;
	}
	public void setPrac(int prac) {
		this.prac = prac;
	}
	public int getSubknowl() {
		return subknowl;
	}
	public void setSubknowl(int subknowl) {
		this.subknowl = subknowl;
	}
	public int getClarity() {
		return clarity;
	}
	public void setClarity(int clarity) {
		this.clarity = clarity;
	}
	public int getResponsive() {
		return responsive;
	}
	public void setResponsive(int responsive) {
		this.responsive = responsive;
	}
	public int getArrangements() {
		return arrangements;
	}
	public void setArrangements(int arrangements) {
		this.arrangements = arrangements;
	}
	public String getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}
	public float getEagg() {
		return eagg;
	}
	public void setEagg(float eagg) {
		this.eagg = eagg;
	}

	@Override
	public String toString() {
		return "Sessfeedbackform [empid=" + empid + ", sesid=" + sesid
				+ ", covcontent=" + covcontent + ", matquality=" + matquality
				+ ", prac=" + prac + ", subknowl=" + subknowl + ", clarity="
				+ clarity + ", responsive=" + responsive + ", arrangements="
				+ arrangements + ", suggestions=" + suggestions + ", eagg="
				+ eagg + "]";
	}
	
	

}
