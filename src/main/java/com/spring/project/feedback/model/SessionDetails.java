package com.spring.project.feedback.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "sessiondetails_view")
public class SessionDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "SessionId")
	private int sessionid;
	@Column(name = "sdate")
	private Date sdate;
	@Column(name = "StartTime")
	private String stime;
	@Column(name = "EndTime")
	private String etime;
	@Column(name = "TopicName")
	private String topicname;
	@Column(name = "TrainerName")
	private String trainername;
	
	
	public int getSessionid() {
		return sessionid;
	}
	public void setSessionid(int sessionid) {
		this.sessionid = sessionid;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getTopicname() {
		return topicname;
	}
	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}
	public String getTrainername() {
		return trainername;
	}
	public void setTrainername(String trainername) {
		this.trainername = trainername;
	}
	@Override
	public String toString() {
		return "SessionDetails [sessionid=" + sessionid + ", sdate=" + sdate
				+ ", stime=" + stime + ", etime=" + etime + ", topicname="
				+ topicname + ", trainername=" + trainername + "]";
	}

	

}
