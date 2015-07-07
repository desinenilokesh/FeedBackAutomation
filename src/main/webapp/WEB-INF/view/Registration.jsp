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
</head>
<script
	src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-1.9.1.js"/>"></script>
<script type="text/javascript">
	function callAjax() {
		var emp = new Object();
		var category = document.getElementById("empids").value;
		$
				.ajax({
					url : '${pageContext.request.contextPath}/registration/fetchdetails',
					method : 'GET',
					data : {
						empid : category
					},
					datatype : "json",
					contentType : 'application/json',
					success : function(data) {

						document.getElementById("name").value = data.name;
						document.getElementById("phoneno").value = data.phoneno;
						document.getElementById("Emailid").value = data.email;

					},
					error : function() {
						alert('error')
					}
				});

	}
	function callSecAjax() {
		var question = document.getElementById("questions").value;
		$.ajax({
			url : '${pageContext.request.contextPath}/registration/getsid',
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
<script>
	$(document).ready(function() {
		$(".commit").click(function() {
			$("flash").slideUp();
		});
	});
</script>
<body>
	<form:form id="loginform" modelAttribute="reg" commandName="reg"
		action="reg" enctype="multipart/form-data">
		<div align="center">
			<table align="center" style="border-spacing: 10px;">
				<tr>
					<td colspan="2"><h1 align="center" style="font-size: 20px">Registration</h1></td>
				</tr>
				<tr>

					<td><label>Emp ID</label></td>
					<td><form:select path="empid" id="empids"
							onChange="callAjax();">
							<form:option value="">--Select emp id</form:option>
							<form:options items="${ids}" />
						</form:select> <FONT color="red"><form:errors style="color: red;font-style: italic;" path="empid" /></FONT></td>
				</tr>



				<!-- <div id="username_inputmiddle_reg"> -->


				<tr>
					<td>
						<h3>
							<label>Name</label>
						</h3>
					</td>
					<td><form:input path="name" type="text" name="name" id="name"
							value="" readonly="true" /></td>

				</tr>

				<tr>
					<td><h3>
							<label>Phone Number</label>
						</h3></td>
					<td><form:input path="phoneno" type="text" name="phoneno"
							id="phoneno" value="" readonly="true" /></td>
				</tr>


				<tr>
					<td><h3>
							<label>Email ID</label>
						</h3></td>
					<td><form:input path="email" type="text" name="Emailid"
							id="Emailid" value="" readonly="true" /></td>

				</tr>

				<tr>
					<td><h3>
							<label>Technologies</label>
						</h3></td>
					<td><form:input path="technologies" type="text"
							name="technologies" value="" /> <FONT color="red"><form:errors
								path="technologies" /></FONT></td>
				</tr>

				<tr>
					<td><h3>
							<label>Password</label>
						</h3></td>
					<td><form:input path="password" type="password"
							name="password" value="" /> <FONT color="red"><form:errors style="color: red;font-style: italic;"
								path="password" /></FONT></td>
				</tr>

				<tr>
					<td><h3>
							<label>Confirm Password</label>
						</h3></td>
					<td><form:input path="confirmpwd" type="password"
							name="confirmpwd" value="" /> <FONT color="red"><form:errors style="color: red;font-style: italic;"
								path="confirmpwd" /></FONT></td>
				</tr>
				<tr>
					<td><label>Security Question</label>
					<td><form:select path="question" id="questions"
							onChange="callSecAjax();">
							<form:option value="">--Select Security Question</form:option>
							<form:options items="${secquestions}" />
						</form:select><form:errors style="color: red;font-style: italic;" path="question" /> </td>
				</tr>
				<tr>
					<td><label>Answer</label></td>
					<td><form:input path="answer" type="text" name="secanswer" /><form:errors style="color: red;font-style: italic;" path="answer" /></td>
				</tr>
				<tr>
					<td><form:label path="file">Image</form:label></td>
					<td><form:input type="file" path="file" name="file" id="file" />
						<form:errors style="color: red;font-style: italic;" path="file" /></td>
				</tr>
				<!--   </div> -->
				<tr>
					<td colspan="2" ><input type="submit"
						name="commit" value="Sign Up"  align="center"/></td>
				</tr>
				<tr>
					<td><form:hidden path="sid" name="secid" /> <%-- <form:input path="sid"  name="secid" /> --%></td>
				</tr>

			</table>
			<div id="flash">
				<h1
					style="color: green; background-color: white; font-family: sans-serif; font-size: 18">${success}</h1>
			</div>
			<a href="${pageContext.request.contextPath}/">Back to Login Page</a>
		</div>


	</form:form>





</body>
</html>