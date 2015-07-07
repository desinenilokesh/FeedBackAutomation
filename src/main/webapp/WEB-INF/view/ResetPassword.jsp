<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ResetPasssword </title>
</head>
<body>
<form:form id="ResetPasswordForm" modelAttribute="RPform" commandName="RPform" action="ResetPassword">
		<div align="center">
<div ><h1 style="color: maroon;background-color: white;font-size: 20;font-style: italic;"> ResetPassword Password Form</h1></div>
			<table align="center" style="border-spacing: 10px;background-color: #FFE6E6">
				<tr>
					<td><label>Temporary Password</label></td>
					<td><form:input path="currentpwd" type="password" name="name" id="name"
							value="" /><form:errors style="color: red;font-style: italic;" path="currentpwd" /></td>
				</tr>
				<tr>
				<td><label>New Password</label></td>
					<td><form:input path="newpwd" type="password" name="empid"
							id="empid" value="" /><form:errors style="color: red;font-style: italic;" path="newpwd" /></td>
				</tr>
			<tr>
				<td><label>Confirm Password</label></td>
					<td><form:input path="Confirmpwd" type="password" name="answer"
							id="answer" value="" /><form:errors style="color: red;font-style: italic;" path="Confirmpwd" /></td>
				</tr>
				<tr>
				<td>
				<form:input type="hidden" path="empid" value='${empid}'/>
				</td>
				</tr>
				
				<tr>
					<td ><input type="submit"
						name="commit" value="Change" /></td>
				</tr>

			</table>
			<a href="${pageContext.request.contextPath}/">Back to Login Page</a>
			<div style="color:green;background-color: white;font-size: 18;font-style: italic;"> ${pwdmatch} ${updated}</div>
		</div>
</div>
	</form:form>
</body>
</html>