package com.spring.project.feedback.dao;

import java.util.List;

import com.spring.project.feedback.form.TrainerForm;
import com.spring.project.feedback.model.SessionTopics;
import com.spring.project.feedback.model.Sessions;
import com.spring.project.feedback.model.Trainer;
import com.spring.project.feedback.model.TrainingPlan;

public interface AdminDao {
	public List<SessionTopics> getTechnologies();

	public List<SessionTopics> getTopics(String technology);

	public Integer gettid(String topicname);

	public List<Trainer> getTrainers(int topicid);

	public int gettrid(int tpid, String trname);

	public int addSession(Sessions session);

	public int insertTrainer(Trainer tr);
}
