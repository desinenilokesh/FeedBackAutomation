package com.spring.project.feedback.form;

public class ResetPasswordForm {
	private String currentpwd;
	private String newpwd;
	private String Confirmpwd;
	private String empid;
	public String getConfirmpwd() {
		return Confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		Confirmpwd = confirmpwd;
	}

	public String getCurrentpwd() {
		return currentpwd;
	}
	public void setCurrentpwd(String currentpwd) {
		this.currentpwd = currentpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	@Override
	public String toString() {
		return "ResetPasswordForm [currentpwd=" + currentpwd + ", newpwd="
				+ newpwd + ", empid=" + empid + "]";
	}
	
	

}
