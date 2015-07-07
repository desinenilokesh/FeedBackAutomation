package com.spring.project.feedback.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.spring.project.feedback.form.RegistrationForm;
import com.spring.project.feedback.model.Employee;
import com.spring.project.feedback.model.GuidTable;
import com.spring.project.feedback.model.SecurityQuestions;
import com.spring.project.feedback.model.UserSecAnswers;

public interface RegistrationService {
	public List<Employee> getids();
	public UserSecAnswers prepareModel(RegistrationForm regform);
	public int InsertEmployee(UserSecAnswers usa);
	public RegistrationForm detailsfetch(String id);

	public List<SecurityQuestions> getsecquestions();
	public Map<Integer,String> processList(List<SecurityQuestions> li);
	public List<String> getQuestions(List<SecurityQuestions> secquli);
	public boolean verifyAnswer(String answer, String answer2);
	public boolean sendEmail(String fromaddress, String mailids,String guid,String tmppwd);
	public String generateGuid();
	public GuidTable prepGuidModel(String guid, String empid,String tmppwd);
	public boolean guidInsert(GuidTable gt);
	public String generateTmppwd();
	public String getEmpid(String id);
	public boolean validateEmp(String empid,String currentpwd);
	public boolean updatePassword(String empid,String newpwd);
}
