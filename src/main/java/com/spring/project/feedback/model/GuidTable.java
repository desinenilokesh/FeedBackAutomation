package com.spring.project.feedback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="guid")
public class GuidTable {
	@Id
	@Column(name="Empid")
	private String empid;
	@Column(name="Guid")
	private String guid;
	@Column(name="Time")
	private String time;
	@Column(name="tmppwd")
	private String tpwd;

	
	
	public String getTpwd() {
		return tpwd;
	}
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "GuidTable [empid=" + empid + ", guid=" + guid + ", time="
				+ time + "]";
	}
	

}
