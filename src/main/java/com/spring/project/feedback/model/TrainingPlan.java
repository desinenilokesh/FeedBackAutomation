package com.spring.project.feedback.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "Sessions")
public class TrainingPlan {


	

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	@Column(name = "SessionId")
	private int sid;

	
	/*@Column(name = "TopicID")
	private int topid;
	
	@Column(name = "TrainerId")
	private int trid;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TopicID")
	private SessionTopics Topics;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TrainerId")
	private Trainer trainers;


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
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


	public SessionTopics getTopics() {
		return Topics;
	}


	public void setTopics(SessionTopics topics) {
		Topics = topics;
	}


	public Trainer getTrainers() {
		return trainers;
	}


	public void setTrainers(Trainer trainers) {
		this.trainers = trainers;
	}


	@Override
	public String toString() {
		return "TrainingPlan [sid=" + sid + ", topid=" + topid + ", trid="
				+ trid + ", Topics=" + Topics + ", trainers=" + trainers + "]";
	}
*/


}
