package com.spring.project.feedback.form;

import java.io.File;
import java.sql.Blob;
import java.util.Arrays;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class RegistrationForm {


	@NotEmpty(message="")
	private String empid;
	@NotEmpty(message="")
	private String name;
	@NotNull
	private String phoneno;
	@NotNull
	private String email;
	@NotEmpty
	private String technologies;
	@Size(min = 4, max = 20)
	private String password;

	private String confirmpwd;

	@NotEmpty
	private String question;
	@NotEmpty
	private String answer;
	private int sid;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	private MultipartFile file;
	private byte[] bytes;

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getConfirmpwd() {
		return confirmpwd;
	}

	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}

	@Override
	public String toString() {
		return "RegistrationForm [empid=" + empid + ", name=" + name
				+ ", phoneno=" + phoneno + ", email=" + email
				+ ", technologies=" + technologies + ", password=" + password
				+ ", confirmpwd=" + confirmpwd + ", sid=" + sid + ", question="
				+ question + ", answer=" + answer + ", file=" + file
				+ ", bytes=" + Arrays.toString(bytes) + "]";
	}
	

}
