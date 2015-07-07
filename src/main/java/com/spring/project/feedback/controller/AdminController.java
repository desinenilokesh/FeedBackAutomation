package com.spring.project.feedback.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.feedback.form.RegistrationForm;
import com.spring.project.feedback.form.SessionForm;
import com.spring.project.feedback.form.TrainerForm;
import com.spring.project.feedback.form.UserForm;
import com.spring.project.feedback.model.SecurityQuestions;
import com.spring.project.feedback.model.SessionTopics;
import com.spring.project.feedback.model.Sessions;
import com.spring.project.feedback.model.Trainer;
import com.spring.project.feedback.model.TrainingPlan;
import com.spring.project.feedback.model.UserSecAnswers;
import com.spring.project.feedback.service.AdminService;
import com.spring.project.feedback.service.LoginService;

@Controller
@RequestMapping(value = "/Admin")
public class AdminController {
	@Autowired
	private AdminService adminservice;
	ModelAndView mav = new ModelAndView();
	Map<String, Integer> trmap = new HashMap<String, Integer>();
	
	Map<String,ArrayList<String>> ttmap=new HashMap<String, ArrayList<String>>();
	
	Map<String,Integer> topicidmap=new HashMap<String,Integer>();
	
	int tid = 0;

	@RequestMapping(value = "/AddSessionview")
	public ModelAndView addsession(
			@ModelAttribute("sessionform") SessionForm sessionform) {
		System.out.println("in AddSessionView");
		List<SessionTopics> techstable = adminservice.getTechnologies();
		
		topicidmap=adminservice.getTopicIdMap(techstable);
		List<String> techs=adminservice.getTechNames(techstable);
		Set<String> uniqtechs=new HashSet<String>(techs);
		ttmap=adminservice.getTTMap(techstable,uniqtechs);
		System.out.println("techologies" + techs);
		System.out.println("techologies" + uniqtechs);
		System.out.println("no of technologoes" + techs.size());
		mav.addObject("technologies", uniqtechs);
		mav.setViewName("AddSession");
		return mav;

	}

	/*@RequestMapping(value = "/AddTrainer")
	public ModelAndView AddTrainer(
			@ModelAttribute("trainerform") TrainerForm trainerform) {
		List<String> techs = adminservice.getTechnologies();
		mav.addObject("technologies", techs);
		mav.setViewName("AddTrainer");
		return mav;

	}*/

	@RequestMapping(value = "/ViewFeedBack")
	public ModelAndView ViewFeedBack(
			@ModelAttribute("sessionform") SessionForm sessionform) {
		mav.setViewName("ViewFeedBack");
		return mav;

	}


	@RequestMapping(value = "/gettopics", method = RequestMethod.GET)
	public @ResponseBody
	List<String> gettopics(@RequestParam("tech") String technology,
			HttpServletResponse res) throws IOException {
		System.out.println("in gettopics");
	//	List<SessionTopics> li = adminservice.getTopics(technology);
		ArrayList<String> topli=ttmap.get(technology) ;
		System.out.println("li" + topli);
		return topli;
	}

	@RequestMapping(value = "/gettid", method = RequestMethod.GET)
	public @ResponseBody
	int gettid(@RequestParam("tname") String topicname, HttpServletResponse res) {
		System.out.println("in get tid");
		System.out.println("in controller");

		//tid = adminservice.gettid(topicname);
		tid=topicidmap.get(topicname);
		System.out.println("topicid"+tid);
		return tid;
	}
	
	
	
	@RequestMapping(value = "/getrnames", method = RequestMethod.GET)
	public @ResponseBody
	Set<String> gettrnames(@RequestParam("tid") int topicid, HttpServletResponse res) {
		System.out.println("in get tid");
		System.out.println("in controller");
		List<Trainer> trainers=adminservice.getTrainers(topicid);
		trmap = adminservice.processtrlist(trainers);
		Set<String> trnames=trmap.keySet();
		System.out.println(trnames);
		return trnames;
	}
	
	
	
	
	

	@RequestMapping(value = "/gettrid", method = RequestMethod.GET)
	public @ResponseBody
	int gettrid(@RequestParam("trainername") String trname,
			HttpServletResponse res) {
		System.out.println("in get tid");
		System.out.println("in controller");
		System.out.println(tid);
		int trid = 0;
		trid=trmap.get(trname);
		return trid;
	}

	@RequestMapping(value = "/sessionadding")
	public ModelAndView sessionadding(HttpServletRequest req,
			@Valid @ModelAttribute("sessionform") SessionForm sessionform,
			BindingResult result) {
		String view;
		String s = null;
		String topic = req.getParameter("topic");
		System.out.println(topic);
		System.out.println(sessionform);
		System.out.println("date length"+sessionform.getSdate().length());
		System.out.println("time length"+sessionform.getStartTime().length());
		if (result.hasErrors() && topic == null) {
			view = "AddSession";
		} else {
			System.out.println("in else");
			ModelAndView mav = new ModelAndView();
			System.out.println("in calling service");
			Sessions session = adminservice.prepareModel(sessionform);
			System.out.println("in session adding" + sessionform);
			System.out.println("training plan object is" + session);
			// System.out.println("in add session"+sessionform);
			int i = adminservice.addsession(session);
			
			if (i > 0) {
				System.out.println("in if");
				s = "Session Added Successfully";
				
				view = "AddSession";

				System.out.println("inserted");
			} else {
				s = "something went wrong";
				
				view = "AddSession";

				System.out.println("pblm");
			}
		}
		mav.addObject("message",s);
	
		mav.setViewName("AddSession");
		return mav;

	}
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest req,@ModelAttribute("user") UserForm userbean)
	{
		HttpSession ses=req.getSession();
		ses.invalidate();
		//mav.setViewName("login");
		return new ModelAndView("redirect:/");
		//return mav;
	}
	@RequestMapping(value="addingtrainer")
	public ModelAndView trainerAdd(HttpServletRequest req,@Valid @ModelAttribute("trainerform") TrainerForm tform,BindingResult result)
	{
		String s = null,view;
		System.out.println(tform);
		String topic=req.getParameter("technology");
		System.out.println(topic);
		if(result.hasErrors() && topic.isEmpty())
		{
			view="AddTrainer";
		}
		else
		{
		Trainer tr=adminservice.prepareTrmodel(tform);
		
		int i=adminservice.insetTrainer(tr);
		if (i > 0) {
			s = "Trainer Added Successfully";
			view = "AddTrainer";

			System.out.println("inserted");
		} else {
			s = "something went wrong";
			view = "AddTrainer";

			System.out.println("pblm");
		}
		}
		mav.addObject("message1",s);

		mav.setViewName(view);
		return mav;
		
	}

}
