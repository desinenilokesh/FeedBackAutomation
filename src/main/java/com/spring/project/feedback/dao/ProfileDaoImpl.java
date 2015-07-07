
package com.spring.project.feedback.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.feedback.model.Emp;

@Repository("profileDao")
public class ProfileDaoImpl implements ProfileDao {
	@Autowired
	private SessionFactory sessionFactory;

	public String getSecQuestion(String empid) {
		String Secquestion = sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						"select SecurityQuestion from usersecuredata usd INNER JOIN securityquestions sqs ON usd.Sid=sqs.id Where usd.Empid= '"
								+ empid + "'").uniqueResult().toString();
		// System.out.println("asdasd"+Secquestion.get(0));
		/*
		 * Query query=sessionFactory .getCurrentSession() .createSQLQuery(
		 * "select SecurityQuestion,Sid from usersecuredata usd INNER JOIN securityquestions sqs ON usd.Sid=sqs.id Where usd.Empid= '"
		 * + empid + "'");
		 */

		return Secquestion;
	}

	public List<Object> checkSecurity(String empId, String secQuestion,
			String secAnswer) {
		List<Object> secRecords = sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						"SELECT * FROM  feedback.usersecuredata usd  INNER JOIN feedback.securityquestions sq on usd.Sid=sq.id And usd.Answer='"
								+ secAnswer
								+ "' where usd.Empid='"
								+ empId
								+ "' ").list();
		return secRecords;
	}

	public List<Emp> getEmps(String empId) {
		List<Emp> emps=sessionFactory.getCurrentSession().createQuery("select e.uname,e.phoneno,e.mailid,e.technologies,e.image From Emp e where e.empid='"+empId+"'").list();
		return emps;
	}

	public int updateUserEmailInfo(String empId, String value) {
		String updateQuery="UPDATE Emp set mailid = :emailid "  + 
             "WHERE id = :employee_id";
		Query query=sessionFactory.getCurrentSession().createQuery(updateQuery);
		query.setParameter("emailid",value);
		query.setParameter("employee_id", empId);
		int i=query.executeUpdate();
		return i;
	}

	public int updateUserPhoneNo(String empId, String value) {
		String updateQuery="UPDATE Emp set phoneno = :phoneno "  + 
	             "WHERE id = :employee_id";
			Query query=sessionFactory.getCurrentSession().createQuery(updateQuery);
			query.setParameter("phoneno",value);
			query.setParameter("employee_id", empId);
			int i=query.executeUpdate();
			return i;
	}

}
