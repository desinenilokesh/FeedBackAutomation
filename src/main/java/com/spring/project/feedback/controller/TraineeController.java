package com.spring.project.feedback.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.feedback.form.RegistrationForm;
import com.spring.project.feedback.service.ProfileService;

@Controller
@RequestMapping(value="/Trainee")
public class TraineeController {
	@Autowired
	private ProfileService profileService;
	
	ModelAndView mav=new ModelAndView();
	String SecQuestion;
	@RequestMapping(value="/editprofileview")
	public ModelAndView editprofileview(HttpServletRequest req,@ModelAttribute("usersec") RegistrationForm regform)
	{
		HttpSession usernamesession=req.getSession();
		String EmpId=(String) usernamesession.getAttribute("empid");
		System.out.println("in trainee controller");
		mav.addObject("EmpId",EmpId );
		mav.setViewName("editprofile");
		return mav;
	}
	@RequestMapping(value="/changepasswordview")
	public ModelAndView changepasswordview()
	{
		System.out.println("in trainee controller");
		mav.setViewName("changepassword");
		return mav;
	}
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest req)
	{
		HttpSession ses=req.getSession();
		ses.invalidate();
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value="/getSecurityQuestion")
	public @ResponseBody String getSecurityQuestion(HttpServletRequest req,@RequestParam("EmpId") String EmpId)
	{
		SecQuestion=profileService.getSecQuestion(EmpId);
		System.out.println("Security Question"+SecQuestion);
		return SecQuestion;
		
	}
	@RequestMapping(value="/CheckSecurity")
	public @ResponseBody String checkSecurity(@RequestParam("EmpId") String EmpId,@RequestParam("secQuestion") String secQuestion,@RequestParam("secAnswer") String secAnswer)
	{
		String statusflag=profileService.checkSecurity(EmpId,secQuestion,secAnswer,SecQuestion);
		return statusflag;
	}
	
	@RequestMapping(value="/updateUserInfo")
	public @ResponseBody String updateUserInfo(@RequestParam("EmpId") String EmpId,@RequestParam("name") String name,@RequestParam("value") String value)
	{
		System.out.println("empId"+EmpId+"name "+name+"value"+value);
		String updateflag=profileService.updateUserInfo(EmpId,name,value);
		return updateflag;
	}

}
