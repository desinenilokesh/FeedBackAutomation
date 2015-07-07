<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/style.css"/>" media="screen" />
<script
	src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-1.9.1.js"/>"></script>
<script type="text/javascript">
function callSecAjax() {
	 var question = document.getElementById("questions").value;
	$.ajax({
		url : '${pageContext.request.contextPath}/getsid',
		method : 'GET',
		data : {
			sq : question
		},
		datatype : "json",
		contentType : 'application/json',
		success : function(data) {
			document.getElementById("sid").value = data;

		},
		error : function() {
			alert('error')
		}

	}); 

}
</script>
</head>
<body>
	<form:form id="loginform" modelAttribute="reg" commandName="reg" action="fgtpwd">
		<div align="center">
		<div><h1 style="color: maroon;background-color: white;font-size: 20;font-style: italic;"> Forgot Password Form</h1></div>
			<table align="center" style="border-spacing: 10px;">
				<tr>
					<td><label>Enter your Name</label></td>
					<td><form:input path="name" type="text" name="name" id="name"
							value="" /><form:errors style="color: red;font-style: italic;" path="name" /></td>
				</tr>
				<tr>
				<td><label>Enter your Employee Id</label></td>
					<td><form:input path="empid" type="text" name="empid"
							id="empid" value="" /><p style="color: red;font-style: italic;">${empmessage}</p><form:errors style="color: red;font-style: italic;" path="empid" /></td>
				</tr>
				<tr>
				<td><label>Select Your Security Question</label></td>
					<td><form:select path="question" id="questions"
							onChange="callSecAjax();">
							<form:option value="">--Select Security Question</form:option>
							<form:options items="${secquestions}" />
						</form:select><form:errors style="color: red;font-style: italic;" path="question" /></td>
				</tr>
				<tr>
				<td><label>Enter your Answer</label></td>
					<td><form:input path="answer" type="text" name="answer"
							id="answer" value="" /><form:errors style="color: red;font-style: italic;" path="answer" /></td>
				</tr>
				<tr>
					<td ><input type="submit"
						name="commit" value="Submit" /></td>
				</tr>
				<tr>
					<td><form:hidden path="sid" name="secid" /></td>
				</tr>

			</table>
			<a href="${pageContext.request.contextPath}/">Back to Login Page</a>
			<div style="color:green;background-color: white;font-size: 18;font-style: italic;">${secmessage}${mailmessage}${secsucmessage}</div>
		</div>
	</form:form>
</body>
</html>