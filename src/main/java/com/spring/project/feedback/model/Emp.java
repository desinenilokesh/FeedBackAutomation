package com.spring.project.feedback.model;

import java.sql.Blob;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="emp")

public class Emp {
	
	@Id

	@Column(name="empid")
	private String empid;
	@Column(name="username")
	private String uname;
	@Column(name="phoneno")
	private String phoneno;
	@Column(name="mailid")
	private String mailid;
	@Column(name="technologies")
	private String technologies;

	@Column(name="password")
	private String password;

	@Column(name="image")
	private byte[] image;
	/*@Column(name="image")
	@Lob
	private Blob image;*/
	
/*	@Column(name="squestionid")
	private int sid;
	@Column(name="answer")
	private String answer;
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}*/

	public String getMailid() {
		return mailid;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", uname=" + uname + ", phoneno="
				+ phoneno + ", mailid=" + mailid + ", technologies="
				+ technologies + ", password=" + password + ", image=" + image
				+ "]";
	}
	
	
	
	

}

