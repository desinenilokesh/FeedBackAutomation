package com.spring.project.feedback.service;

import java.text.ParseException;
import java.util.List;

import com.spring.project.feedback.form.SessionDetailsForm;
import com.spring.project.feedback.form.UserForm;
import com.spring.project.feedback.model.Emp;
import com.spring.project.feedback.model.SessionDetails;
import com.spring.project.feedback.model.UserSecAnswers;

public interface LoginService {
	 Emp preparemodel(UserForm userbean);
	 List<Emp> validateuser(Emp e);
	 UserSecAnswers getpassword(String name, String empid, int sid,
			String answer);
	 List<SessionDetails> getTrainingPlan();
	 List<SessionDetailsForm> getTrainingPlanForm(List<SessionDetails> sdli);
	//public List<SessionDetails> getPreviousSession(List<SessionDetails> trainingplan);
//	public List<SessionDetails> getUpcomingSession(List<SessionDetails> trainingplan);
	 List<List<SessionDetails>> divideSessions(List<SessionDetails> trainingplan) throws ParseException;
	 

}
