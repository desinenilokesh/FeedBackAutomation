package com.spring.project.feedback.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.feedback.form.RegistrationForm;
import com.spring.project.feedback.model.Emp;
import com.spring.project.feedback.model.Employee;
import com.spring.project.feedback.model.GuidTable;
import com.spring.project.feedback.model.SecurityQuestions;
import com.spring.project.feedback.model.UserSecAnswers;

@Repository("regdao")
public class RegistrationDaoImpl implements RegistrationDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> getallids() {
		// TODO Auto-generated method stub.
		/*
		 * String s = "select empid from empployees"; List<Employee> ids =
		 * sessionFactory.getCurrentSession()
		 * .createQuery("empid from Employee").list();
		 */
		List ids = (List) sessionFactory
				.getCurrentSession()
				.createCriteria(Employee.class)
				.setProjection(
						Projections.projectionList().add(
								Projections.property("empid"))).list();
		return ids;
	}

	public int InsertEmp(UserSecAnswers usa) {
		// TODO Auto-generated method stub
		try {
			System.out.println("in dao impl before");
			sessionFactory.getCurrentSession().save(usa);
			System.out.println("in dao impl after");

			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}

	public RegistrationForm fetchdetails(String id) {
		// TODO Auto-generated method stub
		List<Employee> li = sessionFactory.getCurrentSession()
				.createCriteria(Employee.class)
				.add(Restrictions.eq("empid", id)).list();
		RegistrationForm reg = new RegistrationForm();
		Employee e = li.get(0);
		reg.setName(e.getName());
		reg.setEmail(e.getEmailid());
		reg.setPhoneno(e.getPhoneno());
		System.out.println(reg.getName() + reg.getEmail() + reg.getPhoneno());
		return reg;
	}

	public List<SecurityQuestions> getsecquestions() {
		// TODO Auto-generated method stub
		List<SecurityQuestions> secqslist = (List<SecurityQuestions>) sessionFactory
				.getCurrentSession().createQuery("from SecurityQuestions")
				.list();
		System.out.println("in dao impl" + secqslist);
		return secqslist;
	}

	public int guidInsert(GuidTable gt) {
		try {
			sessionFactory.getCurrentSession().save(gt);
			System.out.println("inserted");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public String getEmpid(String id) {
		List<String> empids = sessionFactory
				.getCurrentSession()
				.createCriteria(GuidTable.class)
				.add(Restrictions.eq("guid", id))
				.setProjection(
						Projections.projectionList().add(
								Projections.property("empid"))).list();

		return empids.get(0);
	}

	public List<GuidTable> validateEmp(String empid, String currentpwd) {
		List<GuidTable> empguids = sessionFactory.getCurrentSession()
				.createCriteria(GuidTable.class)
				.add(Restrictions.eq("empid", empid))
				.add(Restrictions.eqOrIsNull("tpwd", currentpwd)).list();

		return empguids;
	}

	public boolean updatePassword(String empid, String newpwd) {
		Emp e = (Emp) sessionFactory.getCurrentSession().get(Emp.class, empid);
		e.setPassword(newpwd);
		try {
			sessionFactory.getCurrentSession().update(e);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
