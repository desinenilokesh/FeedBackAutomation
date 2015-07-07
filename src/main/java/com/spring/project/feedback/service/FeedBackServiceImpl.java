package com.spring.project.feedback.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.feedback.dao.FeedBackDao;
import com.spring.project.feedback.form.Sessfeedbackform;
import com.spring.project.feedback.form.SessionDetailsForm;
import com.spring.project.feedback.model.FeedBack;

@Service("feedbackservice")
@Transactional
public class FeedBackServiceImpl implements FeedBackService {
	
	@Autowired
	private FeedBackDao feedbackDao;
	
	public FeedBack preparemodel(SessionDetailsForm sdf) {
		
		FeedBack fb=new FeedBack();
		fb.setSesid(Integer.parseInt(sdf.getSessionid()));
		fb.setEmpid(sdf.getEmpid());
		String rating[]=new String[7];
		rating=sdf.getRating();
		fb.setCovcontent(Integer.parseInt(rating[0]));
		fb.setMatquality(Integer.parseInt(rating[1]));
		fb.setPrac(Integer.parseInt(rating[2]));
		fb.setSubknowl(Integer.parseInt(rating[3]));
		fb.setClarity(Integer.parseInt(rating[4]));
		fb.setResponsive(Integer.parseInt(rating[5]));
		fb.setArrangements(Integer.parseInt(rating[6]));
		fb.setSuggestions(sdf.getSuggestions());
		
		
		return fb;
	}
	public int submitFeedBack(FeedBack fb) {
		int submitffbflag=feedbackDao.submitFeedBack(fb);
		return submitffbflag;
	}
	public List<Sessfeedbackform> getSessionFeedback(int sid) {
		List<FeedBack> fb=feedbackDao.getSessionFeedBack(sid);
		List<Sessfeedbackform> sffli=calculateAggs(fb);
		
		return sffli;
	}
	private List<Sessfeedbackform> calculateAggs(List<FeedBack> fb) {
		 List<Sessfeedbackform> sffli=new ArrayList<Sessfeedbackform>();
		 for(FeedBack f:fb)
		 {
			 Sessfeedbackform sff=new Sessfeedbackform();
			 sff.setEmpid(f.getEmpid());
			 sff.setSesid(f.getSesid());
			 sff.setCovcontent(f.getCovcontent());
			 sff.setArrangements(f.getArrangements());
			 sff.setClarity(f.getClarity());
			 sff.setMatquality(f.getMatquality());
			 sff.setPrac(f.getPrac());
			 sff.setResponsive(f.getResponsive());
			 sff.setSubknowl(f.getSubknowl());
			 sff.setSuggestions(f.getSuggestions());
			 float empagg=((f.getArrangements()+f.getClarity()+f.getCovcontent()+f.getMatquality()+f.getPrac()+f.getResponsive()+f.getSubknowl())/7);
			 sff.setEagg(empagg);
			 sffli.add(sff);
		 }
		 return sffli;
	}
	public float getTotalAgg(List<Sessfeedbackform> sfbli) {
		int sum=0;
		for(Sessfeedbackform sfb:sfbli)
		{
			sum+=sfb.getEagg();
		}
		return (sum)/sfbli.size();
	}

}
