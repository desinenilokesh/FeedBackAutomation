package com.spring.project.feedback.form;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class SessionForm {
	@NotEmpty
	private String sdate;
	@NotEmpty
	private String startTime;
	@NotEmpty
	private String endTime;
	@NotEmpty
	private String topic;
	@NotEmpty
	private String trainerName;
	@NotEmpty
	private String Technology;
	@NotEmpty
	private String tid;
	@NotEmpty
	private String trid;
	
	public String getTrid() {
		return trid;
	}
	public void setTrid(String trid) {
		this.trid = trid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTechnology() {
		return Technology;
	}
	public void setTechnology(String technology) {
		Technology = technology;
	}

	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	@Override
	public String toString() {
		return "SessionForm [sdate=" + sdate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", topic=" + topic
				+ ", trainerName=" + trainerName + ", Technology=" + Technology
				+ ", tid=" + tid + ", trid=" + trid + "]";
	}
	
	
	

}
