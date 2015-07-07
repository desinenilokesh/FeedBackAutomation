package com.spring.project.feedback.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.spring.project.feedback.form.RegistrationForm;
import com.spring.project.feedback.form.UserForm;
import com.spring.project.feedback.model.Employee;
import com.spring.project.feedback.model.SecurityQuestions;
import com.spring.project.feedback.model.UserSecAnswers;
import com.spring.project.feedback.service.RegistrationService;
import com.spring.project.feedback.validators.FileValidator;
import com.spring.project.feedback.validators.PasswordValidator;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService regservice;
	@Autowired
	private PasswordValidator PwdValidator;
	@Autowired
	private FileValidator fileValidator;
	
	
	Map<Integer,String> smap;
	List<SecurityQuestions> secquli;
	List<String> sqs;
	List<Employee> li;
	
	@RequestMapping(value = "/new")
	public ModelAndView registration(HttpServletResponse res,
			@ModelAttribute("reg") RegistrationForm regbean,
			BindingResult result) {
		ModelAndView regmav = new ModelAndView();

		 li = regservice.getids();
		 secquli=regservice.getsecquestions();
		 sqs=regservice.getQuestions(secquli);
		System.out.println("after getting questions"+sqs);
		 smap=regservice.processList(secquli);
		System.out.println("after preparing map"+smap);
		regmav.addObject("secquestions", sqs);
		regmav.addObject("ids", li);
	
		regmav.setViewName("Registration");
		return regmav;

	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public ModelAndView Registration(@RequestParam("file") MultipartFile file,
			@ModelAttribute("reg") @Valid RegistrationForm regbean,
			BindingResult result,HttpServletRequest req) throws IOException {
		System.out.println("entered fields are" + regbean);
		System.out.println("in controller");
		ModelAndView mav = new ModelAndView();

		String view;
		byte[] bytes = null;
		fileValidator.validate(regbean, result);
		PwdValidator.validate(regbean, result);
		if (result.hasErrors()) {
			System.out.println("in errors ");
			 li = regservice.getids();
			mav.addObject("ids", li);
			//List<SecurityQuestions> secquli=regservice.getsecquestions();
			//List<String> sqs=regservice.getQuestions(secquli);
			mav.addObject("secquestions", sqs);
			view ="Registration";
			
		} else {
			
				
				bytes = file.getBytes();
			
			regbean.setBytes(bytes);
			System.out.println(regbean);
			UserSecAnswers u = regservice.prepareModel(regbean);
			System.out.println("user sec data in controller"+u);
			int i = regservice.InsertEmployee(u);
			System.out.println("count"+i);

			if (i > 0) {
				mav.addObject("success", "Registration Success");
				//mav.addObject("new form", attributeValue)
				view = "Registration";
			} else {
				mav.addObject("success", "something went wrong");
				view = "Registration";
			}
		}
		mav.setViewName(view);

		return mav;
	}

	@RequestMapping(value = "/fetchdetails", method = RequestMethod.GET)
	public @ResponseBody
	RegistrationForm ddlfetch(@RequestParam("empid") String empid,
			HttpServletResponse res) throws IOException {
		System.out.println("in controller");
		System.out.println(empid);
		RegistrationForm li = regservice.detailsfetch(empid);
		System.out.println("list" + li);
		Gson gson = new Gson();
		String empdetails = gson.toJson(li);
		System.out.println("empdetails" + empdetails);
		return li;
		// RegistrationForm regs=li.get(0);
		/*
		 * JSONObject empdetailsjson=new JSONObject(); JSONArray jsonArray = new
		 * JSONArray();
		 * 
		 * for(RegistrationForm regs: li) { JSONObject edetails=new
		 * JSONObject(); edetails.put("details", regs); jsonArray.add
		 * 
		 * }
		 */

		/*
		 * Gson gson=new Gson(); String empdetails=gson.toJson(li);
		 * System.out.println("empdetails"+empdetails);
		 * res.getWriter().write(empdetails); return empdetails;
		 */
		/*
		 * Emp e=regservice.prepareModel(regbean); int
		 * i=regservice.InsertEmployee(e); ModelAndView mav=new ModelAndView();
		 * if(i>0) { mav.addObject("success", "Registration Success");
		 * mav.setViewName("Registration"); } else { mav.addObject("success",
		 * "something went wrong"); mav.setViewName("Registration"); } return
		 * mav;
		 */
	}
	
	@RequestMapping(value = "/getSecQuestions")
	public @ResponseBody List<String>  getSecQuestions() {

		 secquli=regservice.getsecquestions();
		 sqs=regservice.getQuestions(secquli);
		System.out.println("after getting questions"+sqs);
		return sqs;
		
	}
	
	@RequestMapping(value = "/backlogin")
	public ModelAndView backlogin(@ModelAttribute("user") UserForm userbean) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	@RequestMapping(value="/getsid")
	public @ResponseBody int getsid(@RequestParam("sq") String squestion,HttpServletResponse res)
	{
		System.out.println("in get sid");
		int key = 0;
		for(Map.Entry entry: smap.entrySet()){
            if(squestion.equals(entry.getValue())){
                key = (Integer) entry.getKey();
                break; //breaking because its one to one map
            }
        }
		System.out.println("key value is"+key);
		return key;
	}
}
