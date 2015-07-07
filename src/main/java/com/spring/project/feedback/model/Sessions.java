package com.spring.project.feedback.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name="sessions1")
public class Sessions {

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	@Column(name="SessionId")
	private int sid;
	@Column(name="Sdate")
	private Date sdate;
	@Column(name="StartTime")
	private String stime;
	@Column(name="EndTime")
	private String etime;
	
	@Column(name = "TopicID")
	private int topid;
	
	@Column(name = "TrainerId")
	private int trid;
	



	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
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
	


	public int getTopid() {
		return topid;
	}


	public void setTopid(int topid) {
		this.topid = topid;
	}


	public int getTrid() {
		return trid;
	}


	public void setTrid(int trid) {
		this.trid = trid;
	}


	@Override
	public String toString() {
		return "Sessions [sid=" + sid + ", sdate=" + sdate + ", stime=" + stime
				+ ", etime=" + etime + ", topid=" + topid + ", trid=" + trid
				+ "]";
	}





	


	
	
	


	
	

}
