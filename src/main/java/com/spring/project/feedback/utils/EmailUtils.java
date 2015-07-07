package com.spring.project.feedback.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {
	public static boolean sendMail(String Fromaddress, String Toaddress,
			String guid,String tmpPwd) {
		boolean b = false;
		try {
			final String a = "Loki@6282";

			String to = Toaddress;
			String from = Fromaddress;
			System.out.println("from address" + from + "toaddress" + to
					+ "guid" + guid);
		//	String host = "smtp.gmail.com"; //THIS IS FOR GMAIL
			String host="localhost";
			Properties properties = System.getProperties();
			properties.setProperty("mx.valuelabs.net", host);
			properties.put("mail.smtp.host", "mx.valuelabs.net");
			properties.put("mail.smtp.user", "lokesh.desineni@valuelabs.net"); // User
																				// name
			properties.put("mail.smtp.password", "Loki@6282"); // password
			properties.put("mx.valuelabs.net", "25");
			properties.put("mx.valuelabs.net", "true");
			Calendar cal = Calendar.getInstance();
		    cal.set(Calendar.HOUR_OF_DAY, 0);
		    cal.set(Calendar.MINUTE, 0);
		    cal.set(Calendar.SECOND, 0);
		    cal.set(Calendar.MILLISECOND, 0);
		    Date dateWithoutTime = cal.getTime();
			/*Properties props = new Properties();
			 props.put("mail.smtp.starttls.enable", "true"); 
			  props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.starttls.enable", "true");
		      props.put("mail.smtp.host", "smtp.gmail.com");
		      props.put("mail.smtp.port", "587");
		      props.put("mail.smtp.user",Fromaddress);
		      props.put("mail.smtp.password",a);*/
		      
		 /*     properties.put("mail.smtp.starttls.enable", "true"); 
		      properties.put("mail.smtp.host", "smtp.gmail.com");
		      properties.put("mail.smtp.user", "username"); // User name
		      properties.put("mail.smtp.password", "password"); // password
		      properties.put("mail.smtp.port", "587");
		      properties.put("mail.smtp.auth", "true");*/
			Session session = Session.getInstance(properties,
					new javax.mail.Authenticator() {
						protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
							return new javax.mail.PasswordAuthentication(
									"lokesh.desineni", a);
						}
					});
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject("Password recovery");
			message.setContent("<html>\n" +
                    "<body>\n" +
                    "\n" +
                    "<a href=\"http://localhost:8080/FeedBackAutomation/validatelogin?id="+guid+"\">\n" +
                    "http://localhost:8080/FeedBackAutomation/validatelogin?id="+guid+"&ed="+dateWithoutTime+"</a>\n" +
                    "\n" +
                    "</body>\n" +
                    "<h1>your temporary password is"+tmpPwd+"</h1><Strong>This Works only one time</strong>"+
                    "</html>",
					"text/html");

			//message.setText("your password is" + password);
			Transport.send(message);

			b = true;
		} catch (Exception ex) {
			b = false;
			ex.printStackTrace();
		}

		return b;
	}

}
