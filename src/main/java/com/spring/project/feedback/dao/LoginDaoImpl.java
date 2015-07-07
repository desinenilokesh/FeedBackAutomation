package com.spring.project.feedback.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.feedback.model.Emp;
import com.spring.project.feedback.model.SessionDetails;
import com.spring.project.feedback.model.TrainingPlan;
import com.spring.project.feedback.model.UserSecAnswers;

@Repository("logindao")
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Emp> validateuser(Emp e) {
		// TODO Auto-generated method stub
		List<Emp> li = sessionFactory.getCurrentSession()
				.createCriteria(Emp.class)
				.add(Restrictions.eq("uname", e.getUname()))
				.add(Restrictions.eq("password", e.getPassword())).list();

		return li;
	}

	public List<UserSecAnswers> getPassword(String name, String empid, int sid,
			String answer) {
		// TODO Auto-generated method stub
		List<UserSecAnswers> usali = null;
		try {
			System.out.println("name" + name + "empid" + empid + "sid" + sid
					+ "answer" + answer);
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(UserSecAnswers.class, "usa");
			criteria.setFetchMode("usa.emp", FetchMode.JOIN)
					.createAlias("usa.emp", "emp")
					.add(Restrictions.eq("emp.empid", empid))
					.add(Restrictions.eq("emp.uname", name))
					.add(Restrictions.eq("usa.sid", sid));

			usali = criteria.list();
			System.out.println("after query execution");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return usali;

	}

	public List<SessionDetails> getTrainngPlan() {

		/*
		 * SELECT
		 * s.SessionId,s.Sdate,s.StartTime,s.EndTime,tr.TrainerName,tp.TopicName
		 * FROM sessions s INNER JOIN trainingplan trp ON
		 * s.SessionId=trp.SessionId INNER JOIN trainers tr ON
		 * trp.TrainerId=tr.TrainerId INNER JOIN topics tp ON
		 * trp.TopicId=tp.TopicId;
		 */

		//String s = "SELECT s.SessionId,s.Sdate,s.StartTime,s.EndTime,tr.TrainerName,tp.TopicName FROM sessions s INNER JOIN trainingplan trp ON s.SessionId=trp.SessionId INNER JOIN trainers tr ON trp.TrainerId=tr.TrainerId INNER JOIN topics tp ON trp.TopicId=tp.TopicId";
	/*	List<Object[]> li=sessionFactory.getCurrentSession().createSQLQuery(s).list();
		System.out.println("after Execution");
		System.out.println("size"+li.size());*/
		System.out.println("before exec");
		List<SessionDetails> tpli=(List<SessionDetails>) sessionFactory.getCurrentSession().createQuery("From SessionDetails").list();
		System.out.println("after Execution");
		System.out.println("size"+tpli.size());
		return tpli;
	}
}
