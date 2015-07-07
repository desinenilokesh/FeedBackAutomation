package com.spring.project.feedback.service;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.feedback.dao.ProfileDao;
import com.spring.project.feedback.model.Emp;
import com.spring.project.feedback.utils.ValidationUtils;

@Service("profileservice")
@Transactional
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileDao profileDao;

	public String getSecQuestion(String empid) {
		String Secquestion = profileDao.getSecQuestion(empid);
		return Secquestion;
	}

	public String checkSecurity(String empId, String secQuestion,
			String secAnswer, String OriginalQue) {
		String statusFlag;
		if (secQuestion.equals(OriginalQue)) {
			List<Object> secRecords = profileDao.checkSecurity(empId,
					secQuestion, secAnswer);
			if (secRecords.size() > 0) {
				statusFlag = "true";
				List<Emp> emps = profileDao.getEmps(empId);
				ObjectMapper mapper = new ObjectMapper();
				String empsString;
				try {
					statusFlag = mapper.writeValueAsString(emps);
					System.out.println("empsstring value is" + statusFlag);
				} catch (JsonGenerationException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else
				statusFlag = "false";

		}

		else {
			statusFlag = "hack";
		}
		return statusFlag;
	}

	public String updateUserInfo(String empId, String name, String value) {
		String updateFlag = null;
		if (name.contains("email")) {
			if (ValidationUtils.emailValidate(value)) {
				int updatestatus = profileDao.updateUserEmailInfo(empId, value);
				if (updatestatus > 0) {
					updateFlag="success";
				}
				else
				{
					updateFlag="query problem";
				}
			}
			else
			{
				updateFlag="format error";
			}
			
		}
		if (name.contains("phoneno")) {
			if (ValidationUtils.phoneNoValidate(value)) {
				int updatestatus = profileDao.updateUserPhoneNo(empId, value);
				if (updatestatus > 0) {
					updateFlag="success";
				}
				else
				{
					updateFlag="query problem";
				}
			}
			else
			{
				updateFlag="format error";
			}
			
		}
		return updateFlag;
	}

}
