package com.spring.project.feedback.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.feedback.form.Sessfeedbackform;
import com.spring.project.feedback.form.SessionDetailsForm;
import com.spring.project.feedback.model.FeedBack;
import com.spring.project.feedback.model.SessionDetails;
import com.spring.project.feedback.service.FeedBackService;
import com.spring.project.feedback.service.LoginService;

@Controller
@RequestMapping(value="/FeedBack")
public class FeedBackController {
	@Autowired
	private LoginService loginservice;
	@Autowired
	private FeedBackService feedbackservice;
	
	ModelAndView mav=new ModelAndView();
	private String sesid;
	private String view;
	@RequestMapping(value="/Showfeedbackform")
	public ModelAndView showfeedbackform(@ModelAttribute("sdform") SessionDetailsForm sdform,@RequestParam("trainername") String trname,@RequestParam("topicname") String toname,@RequestParam("startdate") String sdate,@RequestParam("starttime") String stime,@RequestParam("endtime") String etime,@RequestParam("sessionid") String sid)
	{
		System.out.println("in feedack controller");
		System.out.println("test" + sdform);
		sesid=sid;
		mav.addObject("trainername", trname);
		mav.addObject("topicname", toname);
		mav.addObject("startdate", sdate);
		mav.addObject("starttime", stime);
		mav.addObject("endtime",etime);
		mav.addObject("sessionid", sid);
		mav.setViewName("feedBack");
		return mav;
	}
	@RequestMapping(value="/ViewSessionFeedback")
	public ModelAndView viewsessionfb(@ModelAttribute("sdform") SessionDetailsForm sdform,@RequestParam("sessionid") String sid)
	{
		System.out.println("in feedack controller");
		System.out.println("test" + sdform);
		sesid=sid;
		mav.addObject("sessionid", sid);
		List<Sessfeedbackform> sfbli=feedbackservice.getSessionFeedback(Integer.parseInt(sid));
		float tagg=feedbackservice.getTotalAgg(sfbli);
		mav.addObject("sessionfb", sfbli);
		mav.addObject("TotalAgg", tagg);
		
		mav.setViewName("ViewSessionFeedBack");
		return mav;
	}
	
	@RequestMapping(value="/getSessions")
	public @ResponseBody List<SessionDetails> getSessions() throws ParseException
	{
		List<SessionDetails> sdli,PreviousSessions;
		 sdli=loginservice.getTrainingPlan();
			
		 PreviousSessions =loginservice.divideSessions(sdli).get(0);
		 System.out.println("after previous");
		
		 return PreviousSessions;
	}
	
	
	@RequestMapping(value="/submitfeedback")
	public ModelAndView submitFeedBack(@ModelAttribute("sdform") @Valid SessionDetailsForm sdform,HttpServletRequest req)
	{
		System.out.println("in feedack controller submit feedback");
		HttpSession ses=req.getSession();
		String empid= (String) ses.getAttribute("empid");
		sdform.setEmpid(empid);
		sdform.setSessionid(sesid);
		String sid=sdform.getSessionid();
		System.out.println("test" + sdform);
		
		FeedBack fb=feedbackservice.preparemodel(sdform);
		int submitfbflag=feedbackservice.submitFeedBack(fb);
		if(submitfbflag>0)
		{
			HttpSession session=req.getSession();
			List<SessionDetails> UpcomingSessions=(List<SessionDetails>) session.getAttribute("upcomingsessions");
			List<SessionDetails> PreviousSessions=(List<SessionDetails>) session.getAttribute("previoussessions");
			view="Traineelogin";
			mav.addObject("upsessionlist",UpcomingSessions);
			mav.addObject("prsessionlist",PreviousSessions);
			
			String imagestring = new sun.misc.BASE64Encoder().encode((byte[])session.getAttribute("image"));
			mav.addObject("img",imagestring);
			
			mav.addObject("feedbackflagmsg", "feedback submitted successfully");
		}
		else
		{
			view="feedBack";
			mav.addObject("message", "something went wrong");
					
		}
		
		mav.setViewName(view);
		return mav;
	}
	
	

}
