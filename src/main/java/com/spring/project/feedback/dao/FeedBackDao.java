package com.spring.project.feedback.dao;

import java.util.List;

import com.spring.project.feedback.model.FeedBack;

public interface FeedBackDao {
	int submitFeedBack(FeedBack fb);
	List<FeedBack> getSessionFeedBack(int sid);

}
