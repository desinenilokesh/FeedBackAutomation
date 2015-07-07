package com.spring.project.feedback.dao;

import java.util.List;

import com.spring.project.feedback.model.Emp;
import com.spring.project.feedback.model.SessionDetails;
import com.spring.project.feedback.model.TrainingPlan;
import com.spring.project.feedback.model.UserSecAnswers;

public interface LoginDao {
	
public List<Emp> validateuser(Emp e);

public List<UserSecAnswers> getPassword(String name, String empid, int sid,
		String answer);

public List<SessionDetails> getTrainngPlan();
}
