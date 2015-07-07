package com.spring.project.feedback.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.feedback.dao.LoginDao;
import com.spring.project.feedback.form.SessionDetailsForm;
import com.spring.project.feedback.form.UserForm;
import com.spring.project.feedback.model.Emp;
import com.spring.project.feedback.model.SessionDetails;
import com.spring.project.feedback.model.UserSecAnswers;
import com.spring.project.feedback.utils.PasswordUtils;
@Service("loginservice")
@Transactional
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDao loginDao;
	public Emp preparemodel(UserForm userbean) {
		// TODO Auto-generated method stub
		Emp e=new Emp();
		e.setUname(userbean.getUsername());
		e.setPassword(userbean.getPassword());

		return e;
	}

	public List<Emp> validateuser(Emp e) {
		// TODO Auto-generated method stub
		e.setPassword(PasswordUtils.encryptpassword(e.getPassword()));
		List<Emp> li=loginDao.validateuser(e);
		return li;
	}

	public UserSecAnswers getpassword(String name, String empid, int sid,
			String answer) {
		// TODO Auto-generated method stub
		List<UserSecAnswers> usali=loginDao.getPassword(name,empid,sid,answer);
		UserSecAnswers usa = null;
		if(usali.size()!=0)
		usa=usali.get(0);
		return usa;
	}

	public List<SessionDetails> getTrainingPlan() {
		List<SessionDetails> sdli=loginDao.getTrainngPlan();
		/*System.out.println("final list size"+tpli.size());
		List<StringBuilder> stli=new ArrayList<StringBuilder>();
		StringBuilder sb=new StringBuilder();
		for(Object[] obj:tpli)
		{
			for(Object obj1:obj)
			{
				sb.append(obj1.toString());
				System.out.println("final object data"+obj1.toString());
			}
			stli.add(sb);
		
		}*/
		
		return sdli;
	}

	public List<SessionDetailsForm> getTrainingPlanForm(
			List<SessionDetails> sdli) {
		List<SessionDetailsForm> sdfli=new ArrayList<SessionDetailsForm>();
		System.out.println("in preparing form");
		int i=0;
		while(sdli.get(i)!=null)
		{
			if(sdli.get(i) instanceof SessionDetails)
				System.out.println("success");
		}
		
		/*for(Object o:sdli)
		{
			
			
			System.out.println("in loop");
			SessionDetails sd=(SessionDetails)o;
			System.out.println("after convetion");
		SessionDetailsForm sdf=new SessionDetailsForm();
			sdf.setSessionid(sd.getSessionid());
			SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd");
			String strdate=df.format(sd.getSdate());
			System.out.println("string date is "+strdate);
			sdf.setSessiondate(strdate);
			sdf.setStarttime(sd.getStime());
			sdf.setEndtime(sd.getEtime());
			sdf.setTopicName(sd.getTopicname());
			sdf.setTrainerName(sd.getTrainername());
			sdfli.add(sdf);
	
		}*/
		return sdfli;
	}

	
/*	public List<SessionDetails> getPreviousSession(
			List<SessionDetails> trainingplan) {
		List<SessionDetails> PreviousSessions=new ArrayList<SessionDetails>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date)+"in prev");
		for(SessionDetails sd1:trainingplan)
		{
			if(date.compareTo(sd1.getSdate())<0)
			{	
				System.out.println(date.compareTo(sd1.getSdate())<0);
				System.out.println("in pr"+sd1.getSdate());
				System.out.println("in if pr");
				PreviousSessions.add(sd1);
			}
		}
		return PreviousSessions;
	}

	
	public List<SessionDetails> getUpcomingSession(
			List<SessionDetails> trainingplan) {
		List<SessionDetails> UpcomingSessions=new ArrayList<SessionDetails>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		for(SessionDetails sd:trainingplan)
		{
			if(date.compareTo(sd.getSdate())>0)
			{
				System.out.println("in up"+sd.getSdate());
				System.out.println("in if up");
				UpcomingSessions.add(sd);
			}
		}
		return UpcomingSessions;
	}

*/	public List<List<SessionDetails>> divideSessions(
			List<SessionDetails> trainingplan) throws ParseException {
		List<SessionDetails> UpcomingSessions=new ArrayList<SessionDetails>();
		List<SessionDetails> PreviousSessions=new ArrayList<SessionDetails>();
		List<List<SessionDetails>> dividedSessions=new ArrayList<List<SessionDetails>>();
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date date = sdf.parse(sdf.format(new Date()));
	    System.out.println("date is"+date);
	    
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    Date dateWithoutTime = cal.getTime();
	    System.out.println("datewithouttime"+dateWithoutTime);
	    System.out.println("date is cal"+dateWithoutTime);
		for(SessionDetails sd:trainingplan)
		{
			System.out.println("sdate is"+sd.getSdate());
			if(dateWithoutTime.before(sd.getSdate()))
			{
				/*System.out.println("in upcoming");*/
				System.out.println("in up"+sd.getSdate());
				System.out.println("in if up");
				UpcomingSessions.add(sd);
			}
			else if(dateWithoutTime.after(sd.getSdate()))
			{
				/*System.out.println("in previous");
				System.out.println(date.compareTo(sd.getSdate())<0);
				System.out.println("in pr"+sd.getSdate());
				System.out.println("in if pr");*/
				PreviousSessions.add(sd);
			}
			/*if(date.compareTo(sd.getSdate())>0)
			{
				System.out.println("in up"+sd.getSdate());
				System.out.println("in if up");
				UpcomingSessions.add(sd);
			}
			else
			{
				System.out.println(date.compareTo(sd.getSdate())<0);
				System.out.println("in pr"+sd.getSdate());
				System.out.println("in if pr");
				PreviousSessions.add(sd);
			}*/
		}
		dividedSessions.add(PreviousSessions);
		dividedSessions.add(UpcomingSessions);
		
		return dividedSessions;
	}

	

	

}
