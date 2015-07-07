package com.spring.project.feedback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.spring.project.feedback.form.SessionForm;
import com.spring.project.feedback.form.TrainerForm;
import com.spring.project.feedback.model.SessionTopics;
import com.spring.project.feedback.model.Sessions;
import com.spring.project.feedback.model.Trainer;
import com.spring.project.feedback.model.TrainingPlan;

public interface AdminService {
	public List<SessionTopics> getTechnologies();
/*
	public List<SessionTopics> getTopics(String technology);*/

	/*public Integer gettid(String topicname);*/

	public List<Trainer> getTrainers(int topicid);

	/*public List<Integer> gettrids(List<Trainer> trainers);

	public Set<String> gettrnames(List<Trainer> trainers);*/

	public Map<String, Integer> processtrlist(List<Trainer> trainers);

/*	public int gettrid(int tid, String trname);*/

	public Sessions prepareModel(SessionForm sessionform);

	public int addsession(Sessions session);

	public int insetTrainer(Trainer tr);

	public Trainer prepareTrmodel(TrainerForm tform);

	public List<String> getTechNames(List<SessionTopics> techstable);

	public Map<String, ArrayList<String>> getTTMap(List<SessionTopics> techstable,Set<String> uniqueTechs);

	public Map<String, Integer> getTopicIdMap(List<SessionTopics> techstable);

}
