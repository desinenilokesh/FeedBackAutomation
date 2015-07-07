package com.spring.project.feedback.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.feedback.dao.RegistrationDao;
import com.spring.project.feedback.form.RegistrationForm;
import com.spring.project.feedback.model.Emp;
import com.spring.project.feedback.model.Employee;
import com.spring.project.feedback.model.GuidTable;
import com.spring.project.feedback.model.SecurityQuestions;
import com.spring.project.feedback.model.UserSecAnswers;
import com.spring.project.feedback.utils.EmailUtils;
import com.spring.project.feedback.utils.PasswordUtils;

@Service("regservice")
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDao regDao;

	public List<Employee> getids() {
		// TODO Auto-generated method stub
		List<Employee> ids = regDao.getallids();
		return ids;
	}

	public UserSecAnswers prepareModel(RegistrationForm regform) {

		UserSecAnswers usa = new UserSecAnswers();
		usa.setSid(regform.getSid());
		usa.setAnswer(regform.getAnswer());
		Emp e = new Emp();
		/*String path="C:/Users/lokesh/Desktop/MyFAProj/FeedBackAutomation/src/main/webapp/resources/userimages/";
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(
					path+ regform.getName() + ".jpg");
			
			System.out.println("file saved at"+path+regform.getName());
			fos.write(regform.getBytes());
			fos.close();
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		System.out.println("username" +regform.getName());	
			StringBuffer url = req.getRequestURL();
			System.out.println("url"+url);
			String uri = req.getRequestURI();
			System.out.println("uri"+uri);
			String ctx = req.getContextPath();
			System.out.println("Ctx"+ctx);
			String base = url.substring(0, url.length() - uri.length() + ctx.length()) + "/";
			System.out.println("base"+base);*/
			
			
		e.setImage(regform.getBytes());
		e.setUname(regform.getName());
		e.setPhoneno(regform.getPhoneno());
		e.setMailid(regform.getEmail());
		e.setTechnologies(regform.getTechnologies());
		e.setPassword(PasswordUtils.encryptpassword(regform.getPassword()));
		e.setEmpid(regform.getEmpid());
		usa.setEmp(e);
		return usa;

	}

	public int InsertEmployee(UserSecAnswers usa) {
		// TODO Auto-generated method stub
		System.out.println("in regservice impl");
		int i = regDao.InsertEmp(usa);
		return i;
	}

	public RegistrationForm detailsfetch(String id) {
		// TODO Auto-generated method stub
		RegistrationForm li = regDao.fetchdetails(id);
		return li;
	}

	public List<SecurityQuestions> getsecquestions() {
		// TODO Auto-generated method stub
		List<SecurityQuestions> secquestionlist = regDao.getsecquestions();
		return secquestionlist;
	}

	public Map<Integer, String> processList(List<SecurityQuestions> li) {
		// TODO Auto-generated method stub
		/*
		 * List<Integer> sid=new ArrayList<Integer>(); List<String> sqs=new
		 * ArrayList<String>();
		 */
		Map<Integer, String> smap = new HashMap<Integer, String>();
		for (SecurityQuestions s : li) {
			smap.put(s.getQid(), s.getSecquestion());
		}
		return smap;
	}

	public List<String> getQuestions(List<SecurityQuestions> secquli) {
		// TODO Auto-generated method stub
		List<String> sqs = new ArrayList<String>();
		for (SecurityQuestions s : secquli) {
			sqs.add(s.getSecquestion());
		}
		return sqs;
	}

	public boolean verifyAnswer(String answer, String answer2) {
		// TODO Auto-generated method stub
		if (answer.equalsIgnoreCase(answer2))
			return true;
		else
			return false;
	}

	public boolean sendEmail(String fromaddress, String mailid,String guid,String tmppwd) {
		// TODO Auto-generated method stub
		boolean b=EmailUtils.sendMail(fromaddress,mailid,guid,tmppwd);
		return b;
	}

	public String generateGuid() {
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
		
		return randomUUIDString;
	}

	public GuidTable prepGuidModel(String guid, String empid,String tmppwd) {
		GuidTable gt=new GuidTable();
		gt.setEmpid(empid);
		gt.setGuid(guid);
		gt.setTime(String.valueOf(System.currentTimeMillis()));
		gt.setTpwd(tmppwd);
		return gt;
	}

	public boolean guidInsert(GuidTable gt) {
		int i=regDao.guidInsert(gt);
		if(i>0)
			return true;
		else
		return false;
	}

	public String generateTmppwd() {
		Random ran=new Random();
		String temppwd=String.valueOf((ran.nextInt(1000)))+String.valueOf((ran.nextInt(2000)));
		
		return temppwd;
	}

	public String getEmpid(String id) {
		String empid=regDao.getEmpid(id);
		return empid;
	}

	public boolean validateEmp(String empid, String currentpwd) {
		List<GuidTable> empguids=regDao.validateEmp(empid,currentpwd);
		if(empguids.size()>0)
			return true;
		else
		return false;
	}

	public boolean updatePassword(String empid, String newpwd) {
		boolean updatepwd=regDao.updatePassword(empid,newpwd);
		return updatepwd;
	}

	

}
