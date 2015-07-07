package com.spring.project.feedback.service;

import java.util.List;

public interface ProfileService {
	String getSecQuestion(String empid);

	String checkSecurity(String empId, String secQuestion, String secAnswer,
			String OriginalQue);

	String updateUserInfo(String empId, String name, String value);
}
