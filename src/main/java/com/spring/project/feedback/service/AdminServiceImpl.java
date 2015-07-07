package com.spring.project.feedback.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.feedback.dao.AdminDao;
import com.spring.project.feedback.form.SessionForm;
import com.spring.project.feedback.form.TrainerForm;
import com.spring.project.feedback.model.SecurityQuestions;
import com.spring.project.feedback.model.SessionTopics;
import com.spring.project.feedback.model.Sessions;
import com.spring.project.feedback.model.Trainer;
import com.spring.project.feedback.model.TrainingPlan;
@Service("adminservice")
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	
	 
	public List<SessionTopics> getTechnologies() {
		List<SessionTopics>  stli=adminDao.getTechnologies();
		return stli;
	}

	 
	public List<Trainer> getTrainers(int topicid) {
		List<Trainer> tli=adminDao.getTrainers(topicid);
		System.out.println("in dao impl"+tli);
		return tli;
	}
	
	 
	public Map<String, Integer> processtrlist(List<Trainer> trainers) {
		Map<String, Integer> trmap = new HashMap<String,Integer>();
		for (Trainer t : trainers) {
			trmap.put(t.getTrname(), t.getTrid());
		}
		return trmap;
		
	}
	
	 
	public Sessions prepareModel(SessionForm sessionform) {
		
		Sessions ses=new Sessions();
		ses.setTopid(Integer.parseInt(sessionform.getTid()));
		ses.setTrid(Integer.parseInt(sessionform.getTrid()));
		java.sql.Date sqldate = null ;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date d = null;
		try {
			d =  formatter.parse(sessionform.getSdate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String s=formatter.format(d);
		System.out.println("sadas"+s);
		System.out.println("date is"+d);
		 sqldate = new java.sql.Date(d.getTime());
		 System.out.println("date is"+sqldate);
		 ses.setSdate(sqldate);
		 ses.setStime(sessionform.getStartTime());
		 ses.setEtime(sessionform.getEndTime());
	
		return ses;
		
		
		/*TrainingPlan trp=new TrainingPlan();
		trp.setTopid(Integer.parseInt(sessionform.getTid()));
		System.out.println("topic id"+Integer.parseInt(sessionform.getTid()));
		trp.setTrid(Integer.parseInt(sessionform.getTrid()));
		System.out.println("trainer id"+Integer.parseInt(sessionform.getTrid()));
		System.out.println("date before"+sessionform.getSdate());
		Sessions ses=new Sessions();
		java.sql.Date sqldate = null ;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		java.util.Date d = null;
		try {
			d =  formatter.parse(sessionform.getSdate());
	} catch (ParseException e) {
			e.printStackTrace();
	}
		String s=sessionform.getSdate();
		System.out.println("date is"+d);
		 sqldate = new java.sql.Date(d.getTime());
		 System.out.println("date is"+sqldate);
		 ses.setSdate(sqldate);
		 ses.setStime(sessionform.getStartTime());
		 ses.setEtime(sessionform.getEndTime());
		 trp.setSessions(ses);
		 return trp;*/
		 
		 
		 
		 
		
	}
	 
	public int addsession(Sessions session) {
		int sescount=adminDao.addSession(session);
		return sescount;
	}
	 
	public int insetTrainer(Trainer tr) {
		int ti=adminDao.insertTrainer(tr);
		return ti;
	}
	 
	public Trainer prepareTrmodel(TrainerForm tform) {
		Trainer tr=new Trainer();
		tr.setToid(tform.getTid());
		tr.setTrname(tform.getTname());
		tr.setExp(tform.getExper());
		return tr;
	}
	 
	public List<String> getTechNames(List<SessionTopics> stli) {
		List<String> technames = new ArrayList<String>();
		for(SessionTopics st:stli)
		{
			technames.add(st.getTechnology());
		}
		return technames;
	}
	 
	public Map<String, ArrayList<String>> getTTMap(List<SessionTopics> stli,Set<String> uniqueTechs) {
		
		Map<String,ArrayList<String>> ttmap = new HashMap<String, ArrayList<String>>();
		for(String s:uniqueTechs)
		
		{
			ArrayList<String> topli = new ArrayList<String>();
			for(SessionTopics st:stli)
			{
				if(st.getTechnology().equals(s))
				{
					System.out.println("session topic"+st);
					
					if(ttmap.containsKey(st.getTechnology()))
					{
						topli=ttmap.get(st.getTechnology());
						ttmap.remove(st.getTechnology());
					}
					topli.add(st.getTname());
					
					
				}
			
				else
				{
					continue;
				}
				ttmap.put(st.getTechnology(), topli);
				
			
			}
			
		  //	topli.clear();
			
		}
		System.out.println(ttmap.entrySet()+" available topics");
		return ttmap;
	}
	 
	public Map<String, Integer> getTopicIdMap(List<SessionTopics> techstable) {
		Map<String,Integer> topicidmap=new HashMap<String, Integer>();
		for(SessionTopics st:techstable)
		{
			topicidmap.put(st.getTname(),st.getTid());
		}
		return topicidmap;
	}
}
