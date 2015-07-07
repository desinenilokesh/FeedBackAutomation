package com.spring.project.feedback.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="usersecuredata")

public class UserSecAnswers {
	@Id
	@Column(name="Sid")
	private int sid;
	@Column(name="Answer")
	private String answer;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empid")
	private Emp emp;
	
	
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}

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
	}
	@Override
	public String toString() {
		return "UserSecAnswers [sid=" + sid + ", answer=" + answer + ", emp="
				+ emp + "]";
	}
	

}
