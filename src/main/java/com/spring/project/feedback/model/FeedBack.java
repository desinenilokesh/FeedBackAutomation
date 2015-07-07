package com.spring.project.feedback.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="userreview")
public class FeedBack implements Serializable{
	
	@Id
	@Column(name="Empid")
	private String empid;
	@Id
	@Column(name="Sessionid")
	private int sesid;
	
	@Column(name="Coverageofcontent")
	private int covcontent;
	@Column(name="MaterialQuality")
	private int matquality;
	@Column(name="Practical")
	private int prac;
	@Column(name="Subknowl")
	private int subknowl;
	@Column(name="Clarity")
	private int clarity;
	@Column(name="Responsive")
	private int responsive;
	@Column(name="Arrangements")
	private int arrangements;
	@Column(name="Suggestions")
	private String suggestions;
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
	@Override
	public String toString() {
		return "FeedBack [empid=" + empid + ", Sessionid=" + sesid
				+ ", covcontent=" + covcontent + ", matquality=" + matquality
				+ ", prac=" + prac + ", subknowl=" + subknowl + ", clarity="
				+ clarity + ", responsive=" + responsive + ", arrangements="
				+ arrangements + ", suggestions=" + suggestions + "]";
	}

	
	
}
