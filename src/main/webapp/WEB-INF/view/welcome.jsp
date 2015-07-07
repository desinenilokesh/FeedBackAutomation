<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.spring.project.feedback.form.UserForm"%>
     <%@page import="com.spring.project.feedback.model.Emp"%>
<%@ page import="java.util.*,java.text.*,java.sql.Blob,java.io.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		
		String loggedin = (String)session.getAttribute("loggedin");
		out.println("status"+loggedin);

		if((loggedin != null) && (loggedin.equals("yes")))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
			String date = sdf.format(new Date());

			out.println(date);	

	
			out.println("Welcome "+session.getAttribute("username")+"\t");
			
		
	
			
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
		
		%>
<h1> login successful </h1>
<%= session.getAttribute("username") %>
<img alt="image" src="${pageContext.servletContext.contextPath}/resources/userimages/<%= session.getAttribute("username") %>.jpg" height="100" width="100"/>
<a href="logout"> logout</a>
</body>
</html>