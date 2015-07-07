package com.spring.project.feedback.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.feedback.form.TrainerForm;
import com.spring.project.feedback.model.Employee;
import com.spring.project.feedback.model.SessionTopics;
import com.spring.project.feedback.model.Sessions;
import com.spring.project.feedback.model.Trainer;
import com.spring.project.feedback.model.TrainingPlan;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	@Autowired
	private SessionFactory sessionFactory;

	 
	public List<SessionTopics> getTechnologies() {

		Criteria criteria = sessionFactory
				.getCurrentSession()
				.createCriteria(SessionTopics.class);
//		criteria.setProjection(Projections.distinct(Projections
//				.property("technology")));
		List<SessionTopics> li = criteria.list();
		return li;
	}

	 
	public List<SessionTopics> getTopics(String technology) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				SessionTopics.class);
		criteria.add(Restrictions.eq("technology", technology));
		criteria.setProjection(Projections.projectionList().add(
			Projections.property("tname")));
		/*criteria.setProjection(Projections.projectionList().add(
				Projections.groupProperty("technology")));*/
		List<SessionTopics> li = criteria.list();
		System.out.println("topic list is"+li);
		return li;
	}

	 
	public Integer gettid(String topicname) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SessionTopics.class);
		criteria.add(Restrictions.eq("tname", topicname));
		criteria.setProjection(Projections.projectionList().add(Projections.property("tid")));
		List<Integer> li=criteria.list();
		System.out.println("topic size"+li.size());
		return li.get(0);
	}

	 
	public List<Trainer> getTrainers(int topicid) {
		// TODO Auto-generated method stub
		
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Trainer.class);
		criteria.add(Restrictions.eq("toid", topicid));
		
/*	criteria.setProjection(Projections.distinct(Projections
				.property("trname")));*/
		List<Trainer> trli=criteria.list();
		System.out.println("in dao impl"+trli);
		return trli;
	}

	 
	public int gettrid(int tpid, String trname) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Trainer.class);
		criteria.add(Restrictions.eq("toid", tpid));
		criteria.add(Restrictions.eq("trname", trname));
		criteria.setProjection(Projections.projectionList().add(Projections.property("trid")));
		List<Integer> li=criteria.list();
		return li.get(0);
		
	}

	 
	public int addSession(Sessions session) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().save(session);
		return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		
	}

	 
	public int insertTrainer(Trainer tr) {
		try {
			sessionFactory.getCurrentSession().save(tr);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
}
