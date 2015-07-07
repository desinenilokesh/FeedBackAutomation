package com.spring.project.feedback.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class TrainerForm {
	@NotEmpty
	private String tname;
	@NotEmpty
	private String technology;
	@NotEmpty
	private String Topic;
	@NotNull @Min(1) @Max(10)
	private Integer exper;

	private int tid;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getTopic() {
		return Topic;
	}
	public void setTopic(String topic) {
		Topic = topic;
	}
	
	public Integer getExper() {
		return exper;
	}
	public void setExper(Integer exper) {
		this.exper = exper;
	}
	
	@Override
	public String toString() {
		return "TrainerForm [tname=" + tname + ", technology=" + technology
				+ ", Topic=" + Topic + ", exper=" + exper + ", tid=" + tid
				+ "]";
	}

	

}
