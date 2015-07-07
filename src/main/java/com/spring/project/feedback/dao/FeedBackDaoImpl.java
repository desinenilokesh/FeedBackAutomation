package com.spring.project.feedback.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.feedback.model.FeedBack;

@Repository("feedbackDao")
public class FeedBackDaoImpl implements FeedBackDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int submitFeedBack(FeedBack fb) {
		try {
			sessionFactory.getCurrentSession().save(fb);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public List<FeedBack> getSessionFeedBack(int sid) {
		// http://www.mkyong.com/hibernate/hibernate-parameter-binding-examples/

		List<FeedBack> fbli = sessionFactory.getCurrentSession()
				.createCriteria(FeedBack.class, "fb")
				.add(Restrictions.eq("sesid", sid)).list();

		return fbli;
	}

}
