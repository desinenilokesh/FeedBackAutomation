package com.spring.project.feedback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="securityquestions")

public class SecurityQuestions {
	@Id
	@Column(name="id")
	private int qid;
	@Column(name="SecurityQuestion")
	private String secquestion;
	
	@Override
	public String toString() {
		return "SecurityQuestions [qid=" + qid + ", secquestion=" + secquestion
				+ "]";
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getSecquestion() {
		return secquestion;
	}
	public void setSecquestion(String secquestion) {
		this.secquestion = secquestion;
	}
	

}
