package com.spring.project.feedback.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
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
import com.spring.project.feedback.form.ResetPasswordForm;
import com.spring.project.feedback.form.SessionDetailsForm;
import com.spring.project.feedback.form.SessionForm;
import com.spring.project.feedback.form.UserForm;
import com.spring.project.feedback.model.Emp;
import com.spring.project.feedback.model.GuidTable;
import com.spring.project.feedback.model.SecurityQuestions;
import com.spring.project.feedback.model.SessionDetails;
import com.spring.project.feedback.model.UserSecAnswers;
import com.spring.project.feedback.service.LoginService;
import com.spring.project.feedback.service.RegistrationService;
import com.spring.project.feedback.utils.PasswordUtils;
import com.spring.project.feedback.validators.ForgotPwdValidator;

@Controller
public class LoginController {

	@Autowired
	private RegistrationService regservice;
	@Autowired
	private LoginService loginservice;
	@Autowired
	private ForgotPwdValidator fgtpwdvalidator;

	ModelAndView mav = new ModelAndView();
	Map<Integer, String> smap;
	boolean sortflag;
	List<SessionDetails> sdli;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("user") UserForm userbean,
			HttpServletResponse res) {
		res.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
		res.setHeader("Pragma", "no-cache");

		mav.setViewName("login");
		return mav;

	}

	@RequestMapping(value = "/validatelogin", params = { "id" })
	public ModelAndView resetPassword(
			@ModelAttribute("RPform") ResetPasswordForm rpForm,
			@RequestParam("id") String id) {
		String empid = regservice.getEmpid(id);
		System.out.println("empid is" + empid);
		mav.addObject("empid", empid);

		mav.setViewName("ResetPassword");

		return mav;
	}

	@RequestMapping(value = "/ResetPassword")
	public ModelAndView resetPasswordSubmit(
			@ModelAttribute("RPform") ResetPasswordForm rpForm) {
		System.out.println("enterd fields are" + rpForm);
		boolean pwdmatch = regservice.validateEmp(rpForm.getEmpid(),
				rpForm.getCurrentpwd());
		String view, messasge = null;
		if (pwdmatch) {
			boolean update = regservice.updatePassword(rpForm.getEmpid(),
					PasswordUtils.encryptpassword(rpForm.getNewpwd()));
			if (update) {
				messasge = "updated Successfully";
				view = "ResetPassword";
				mav.addObject("updated", messasge);
			} else {
				view = "ResetPassword";
				messasge = "something went wrong while updating";
				mav.addObject("updated", messasge);
			}
		} else {
			view = "ResetPassword";
			messasge = "your current password is wrong";
			mav.addObject("pwdmatch", messasge);
			messasge = "";

		}
		mav.setViewName(view);
		return mav;
	}

	@RequestMapping(value = "/validatelogin")
	public ModelAndView login(HttpServletResponse res, HttpServletRequest req,
			@Valid UserForm uform, @ModelAttribute("user") UserForm userbean,
			@ModelAttribute("sessionform") SessionForm sesform,
			@ModelAttribute("sdform") SessionDetailsForm sdform,
			BindingResult result) throws IOException, ParseException {
		res.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
		res.setHeader("Pragma", "no-cache");

		String view;
		String path = null;
		List<SessionDetails> UpcomingSessions;
		List<SessionDetails> PreviousSessions;

		// ModelAndView mav = new ModelAndView();
		String x = null;
		if (result.hasErrors()) {
			view = "login";

		} else {
			// HttpSession session = req.getSession();

			if (userbean.getUsername() == null) {
				view = "login";

			} else {

				HttpSession session = req.getSession();
				ServletContext sc = session.getServletContext();
				String x1 = sc.getRealPath("/");
				System.out.println(x1);
				// String username = (String) session.getAttribute("username");

				System.out.println("userbean is " + userbean);
				if (userbean.getUsername().equals("admin")
						&& userbean.getPassword().equals("admin")) {
					System.out.println("in admin login");
					return new ModelAndView("redirect:/Admin/AddSessionview");
					// view="redirect:/Admin/AddSessionview";
					// view="AddSession";

				} else {
					Emp e = loginservice.preparemodel(userbean);
					List<Emp> li = loginservice.validateuser(e);
					if (li.size() == 1) {
						x = "";
						Emp e2 = li.get(0);
						System.out.println("in else");
						view = "Traineelogin";
						session.setAttribute("loggedin", "yes");
						session.setAttribute("username", e2.getUname());
						session.setAttribute("empid", e2.getEmpid());

						sdli = loginservice.getTrainingPlan();

						PreviousSessions = loginservice.divideSessions(sdli)
								.get(0);
						session.setAttribute("previoussessions",
								PreviousSessions);
						System.out.println("after previous");
						UpcomingSessions = loginservice.divideSessions(sdli)
								.get(1);
						System.out.println("after upcoming");
						session.setAttribute("upcomingsessions",
								UpcomingSessions);

						mav.addObject("upsessionlist", UpcomingSessions);
						mav.addObject("prsessionlist", PreviousSessions);
						// mav.addObject("uname", e2.getUname());
						System.out.println("image" + e2.getImage());

						String imagestring = new sun.misc.BASE64Encoder()
								.encode(e2.getImage());
						mav.addObject("img", imagestring);
						System.out.println("training plan size" + sdli.size());
						System.out.println("training plan" + sdli);

					} else {
						x = "invalid Username/password";
						view = "login";
						mav.addObject("message", x);
					}
				}

			}
		}

		mav.setViewName(view);
		// x="";
		return mav;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute("user") UserForm userbean) {
		res.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
		res.setHeader("Pragma", "no-cache");

		HttpSession session = req.getSession();
		session.removeAttribute("userprofile");
		session.removeAttribute("loggedin");
		session.invalidate();// invalidating the session
		mav.setViewName("login");

		return mav;
	}

	@RequestMapping(value = "/forgotpasswordview")
	public ModelAndView fgtpwdview(
			@ModelAttribute("reg") RegistrationForm regbean) {
		// SecurityQuestionsutils sec=new SecurityQuestionsutils();
		List<SecurityQuestions> secquli = regservice.getsecquestions();
		List<String> sqs = regservice.getQuestions(secquli);
		System.out.println("after getting questions" + sqs);
		smap = regservice.processList(secquli);
		System.out.println("after preparing map" + smap);
		mav.addObject("secquestions", sqs);
		mav.setViewName("forgotpassword");
		return mav;
	}

	/*
	 * @RequestMapping(value = "/test") public ModelAndView
	 * test(@ModelAttribute("sessionform") SessionForm sesform ) {
	 * 
	 * mav.setViewName("userhome"); return mav; }
	 */

	@RequestMapping(value = "/getsid")
	public @ResponseBody
	int getsid(@RequestParam("sq") String squestion, HttpServletResponse res) {

		System.out.println("in get sid");
		int key = 0;
		for (Map.Entry entry : smap.entrySet()) {
			if (squestion.equals(entry.getValue())) {
				key = (Integer) entry.getKey();
				break; // breaking because its one to one map
			}
		}
		System.out.println("key value is" + key);
		return key;
	}

	@RequestMapping(value = "/fgtpwd")
	public ModelAndView fgtpwd(
			@ModelAttribute("reg") @Valid RegistrationForm regbean,
			BindingResult result) {
		System.out.println("in fgtpwd method");
		String view;
		Emp e = null;
		boolean b = false;
		boolean mb = false;
		System.out.println(regbean.getEmpid());
		System.out.println("data \n" + regbean);
		fgtpwdvalidator.validate(regbean, result);
		List<SecurityQuestions> secquli = regservice.getsecquestions();
		List<String> sqs = regservice.getQuestions(secquli);
		mav.addObject("secquestions", sqs);
		boolean b2 = false;
		b2 = regbean.getName() != null && !regbean.getName().isEmpty()
				&& regbean.getEmpid() != null && !regbean.getEmpid().isEmpty()
				&& regbean.getQuestion() != null
				&& !regbean.getQuestion().isEmpty()
				&& regbean.getAnswer() != null
				&& !regbean.getAnswer().isEmpty();
		System.out.println("boolean b" + b2);
		if (b2) {

			UserSecAnswers usa = loginservice.getpassword(regbean.getName(),
					regbean.getEmpid(), regbean.getSid(), regbean.getAnswer());
			if (usa != null) {
				System.out.println("answer " + usa.getAnswer());
				System.out.println("sid" + usa.getSid());
				e = usa.getEmp();
				System.out.println("empid" + e.getEmpid());
				System.out.println("email" + e.getMailid());
				b = regservice.verifyAnswer(regbean.getAnswer(),
						usa.getAnswer());

				System.out.println(b);
			} else {
				mav.addObject("secmessage",
						"empid and name are wrong no such user exists");
			}
			if (b == false) {
				mav.addObject("secmessage",
						"Security Question and Answer are Wrong");

			} else {
				String Fromaddress = "lokesh.desineni@valuelabs.net";
				String guid = regservice.generateGuid();
				String tmppwd = regservice.generateTmppwd();
				GuidTable gt = regservice.prepGuidModel(guid, e.getEmpid(),
						tmppwd);
				boolean guidInsert = regservice.guidInsert(gt);
				System.out.println("guid");
				System.out.println("flag" + guidInsert);
				mb = regservice.sendEmail(Fromaddress, e.getMailid(), guid,
						tmppwd);
				if (mb) {
					String message = "mail Sent to your mail id"
							+ e.getMailid() + "\n please Check your inbox";
					mav.addObject("secsucmessage", message);

				} else {
					mav.addObject("mailmessage",
							"Something went wrong in sending mail");

				}

			}

			view = "forgotpassword";

		}
		return mav;
	}

}
