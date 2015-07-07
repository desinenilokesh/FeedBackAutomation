<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.spring.project.feedback.form.UserForm"%>
<%@ page import="java.util.*,java.text.*"%>

<html>
<head>
<meta charset="utf-8">
<title>Login Form</title>
<!-- Load Javascript -->
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.query-2.1.7.js"/>"></script>


<!-- // Load Javascipt -->

<!-- Load stylesheets -->
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/style.css"/>" media="screen" />
<!-- // Load stylesheets -->

<script>


	function submit() {
		var uname = document.forms[0].elements[0].value;
		var password = document.forms[0].elements[1].value;
		var alertmsg = "";
		if (uname == "userName" || uname.length == 0) {
			alertmsg = "pls enter usrname"
		}

		if (password == "Password" || password.length == 0) {
			alertmsg = alertmsg + "please enter password"
		}
		if (alertmsg.length > 0) {
			alert(alertmsg);
			return false;
		} else {
			document.getElementById("loginform").submit();
			return true;
		}
	}
	/*  document.getElementById("loginform").submit(); */
	function Reset(control)
	{
		control.value="";
		
		document.getElementById("flagmsg").innerHTML="";
	}
</script>

</head>
<body class="body_login" ng-app="sortApp" ng-controller="mainController">
	<div id="wrapper">
		<div id="wrappertop"></div>

		<form:form name="loginform" modelAttribute="user" commandName="user"
			action="validatelogin">
			<div id="wrappermiddle">

				<h2>Login</h2>

				<div id="username_input">

					<div id="username_inputleft"></div>

					<div id="username_inputmiddle">

						<form:input path="Username" name="username" id="url"
							value="userName" default="userName" onclick="Reset(this);" />
						<img id="url_user"
							src="<c:url value="/resources/images/usericon.png"/>" alt="" />

					</div>

					<div id="username_inputright"></div>

				</div>

				<div id="password_input">

					<div id="password_inputleft"></div>

					<div id="password_inputmiddle">

						<form:input path="Password" type="password" name="password"
							id="url" value="Password" default="Password"
							onclick="Reset(this)" />
						<img id="url_password"
							src="<c:url value="/resources/images/passicon.png"/>" alt="" />

					</div>

					<div id="password_inputright"></div>

				</div>

				<div id="submit">

					<!-- <input type="image" src="./images/submit_hover.png" id="submit1" value="Sign In"> -->
					<a href="#" onclick="return submit()"><input type="image"
						src="<c:url value="/resources/images/submit.png"/>" id="submit2"
						value="Sign In" /></a>

				</div>


				<div id="links_left">

					<a href="forgotpasswordview" style="font-size: 16px;">Forgot your Password?</a>
				

				</div>

				<div id="links_right">
					<a href="registration/new" style="font-size: 16px;	">Not a Member Yet?</a>
				</div>

			</div>
		</form:form>

		<div id="wrapperbottom"></div>

		<div id="powered">
			<p>
				Powered by <a href="http://www.valuelabs.com/">Value Labs</a>
			</p>
		</div>
		<br/>
		<div style="color: red;background-color: white;font-size: 20px;font-style: italic;" id="flagmsg">${message}</div>
	</div>
</body>
</html>









