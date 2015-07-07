package com.spring.project.feedback.dao;

import java.util.List;

import com.spring.project.feedback.model.Emp;

public interface ProfileDao {
	String getSecQuestion(String empid);

	List<Object> checkSecurity(String empId, String secQuestion, String secAnswer);

	List<Emp> getEmps(String empId);


	int updateUserEmailInfo(String empId, String value);

	int updateUserPhoneNo(String empId, String value);
}
