package com.spring.project.feedback.service;

import java.util.List;

import com.spring.project.feedback.form.Sessfeedbackform;
import com.spring.project.feedback.form.SessionDetailsForm;
import com.spring.project.feedback.model.FeedBack;

public interface FeedBackService {

	public FeedBack preparemodel(SessionDetailsForm sdf);
	int submitFeedBack(FeedBack fb);
	List<Sessfeedbackform> getSessionFeedback(int sid);
	public float getTotalAgg(List<Sessfeedbackform> sfbli);
}
