package com.spring.project.feedback.dao;

import java.util.List;

import com.spring.project.feedback.form.RegistrationForm;
import com.spring.project.feedback.model.Emp;
import com.spring.project.feedback.model.Employee;
import com.spring.project.feedback.model.GuidTable;
import com.spring.project.feedback.model.SecurityQuestions;
import com.spring.project.feedback.model.UserSecAnswers;

public interface RegistrationDao {
	public List<Employee> getallids();

	public int InsertEmp(UserSecAnswers usa);

	public RegistrationForm fetchdetails(String id);
	
	public List<SecurityQuestions> getsecquestions();

	public int guidInsert(GuidTable gt);
	public String getEmpid(String id);
	public List<GuidTable> validateEmp(String empid,String currentpwd);
	public boolean updatePassword(String empid,String newpwd);
}
