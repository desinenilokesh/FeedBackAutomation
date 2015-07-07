<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Profile</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/style.css"/>" media="screen" />
	<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/EditProfile.css"/>" media="screen" />
		<link href="<c:url value='/resources/css/lightbox.css' />" type="text/css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/EditProfile.js"/>"></script>
	<script src="<c:url value="/resources/js/lightbox.min.js"/>"></script>
<script>
function getSecquestion()
{
	var empid=document.getElementById("empid").value;
	$.ajax({
		url : '../Trainee/getSecurityQuestion',
		method : 'GET',
		contentType : 'application/json',
		data:{
			EmpId:empid
		},
		success : function(data) {
			document.getElementById("Secquestion").value=data;
			document.getElementById("updateSecquestion").innerHTML=data;
			
			
		},
		error : function() {
			console.log('error');
		}

	});
	}
	
	function checkSecurity()
	{
		var empid=document.getElementById("empid").value;
		var question=document.getElementById("Secquestion").value;
		var answer=document.getElementById("secanswer").value;
		
		$.ajax({
			url : '../Trainee/CheckSecurity',
			method : 'GET',
			dataType:"json",
			contentType : 'application/json',
			data:{
				EmpId:empid,
				secQuestion:question,
				secAnswer:answer
				
			},
			success : function(data) {
		
				procesSecureFlag(data,answer);
			},
			error : function() {
				console.log('error');
			}

		});
	}
	function procesSecureFlag(data,answer)
	{
			if(data=="false")
				{
				document.getElementById("updateform").innerHTML="";
				
				document.getElementById("error").innerHTML="<h3 style='color:red;'>Security questions and answer are not matching</h3>";
				}
			else if(data=="hack")
				{
				document.getElementById("updateform").innerHTML="";
				document.getElementById("error").innerHTML="<h3 style='color:red;'>Security Breach</h3>";
				}
			else if(data!=null)
				{
				var details=data[0];
				document.getElementById("error").innerHTML="";
				document.getElementById("updateAnswer").innerHTML=answer;
				document.getElementById("pemail").innerHTML=details[2];
				document.getElementById("Username").innerHTML=details[0];
				document.getElementById("Phoneno").innerHTML=details[1];
				document.getElementById("Technologies").innerHTML=details[3];
				document.getElementById("ppic").href="data:image/jpeg;base64,"+details[4];
				document.getElementById("prpic").src="data:image/jpeg;base64,"+details[4];
				
				document.getElementById("updateform").style.display="block";
								
				}
	}
	
</script>
</head>
<body style="padding-left: 20%; padding-right: 20%;"
	onload="getSecquestion();">
	<%@ include file="TraineeTop.jsp"%>
	<form:form id="editprofileform" modelAttribute="usersec"
		commandName="usersec">

		<table align="center" style="border-spacing: 10px;">
			<tr>
				<td colspan="2">
					<h1 style="text-align: center;">Edit Profile</h1>
				</td>
			</tr>
			<tr>
				<td><label>Security Question</label>
				<td><form:input path="question" type="textarea"
						name="secquestion" id="Secquestion" size="50" disabled="true" />
					<form:errors style="color: red;font-style: italic;" path="question" />
				</td>
			</tr>
			<tr>
				<td><label>Answer</label></td>
				<td><form:input path="answer" type="text" name="secanswer"
						id="secanswer" />
					<form:errors style="color: red;font-style: italic;" path="answer" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="submit"
					align="middle" onclick="checkSecurity();" />
			</tr>
		</table>
		<input type="hidden" value='${EmpId }' id="empid" />

	</form:form>
	
	
	<div id="error"></div>
	<div style="display: none;" id="updateform">
		<form:form>
			







<div id="updatewrapper">
		<header>
			<h1>Your Profile</h1>
		</header>
		
		<section id="core">
			<div class="profileinfo">
				<h2>Update your Profile Info &rarr;</h2>
				
				<div class="gear">
					<label>Primary E-Mail:</label>
					<span id="pemail" class="datainfo"></span>
					<a href="#" id="emailclick" class="editlink">Edit Info</a>
					<a class="savebtn" id="emailsave">Save</a>
				</div>
				
				<div class="gear">
					<label>User Name:</label>
					<span id="Username" class="datainfo"></span>
					<a href="#" id="unameclick" class="editlink">Edit Info</a>
					<a class="savebtn" id="unamesave">Save</a>
				</div>
				
				<div class="gear">
					<label>Phone no:</label>
					<span id="Phoneno" class="datainfo"></span>
					<a href="#" class="editlink" id="phonenoclick">Edit Info</a>
					<a class="savebtn" id="phonenosave">Save</a>
				</div>
				
				<div class="gear">
					<label>Technologies</label>
					<span id="Technologies" class="datainfo"></span>
					<a href="#" class="editlink" id="techclick">Edit Info</a>
					<a class="savebtn" id="techsave">Save</a>
				</div>
				
				<div class="gear">
					<label>Security Question:</label>
				<span id="updateSecquestion" class="datainfo"></span>
					<a href="#" class="editlink" id="secquestionclick">Edit Info</a>
					<a class="savebtn" id="secsave">Save</a>
				</div>
				
				<div class="gear">
					<label>Answer</label>
					<span id="updateAnswer" class="datainfo"></span>
					<a href="#" class="editlink" id="ansclick">Edit Info</a>
					<a class="savebtn" id="anssave">Save</a>
				</div>

				<div class="gear">
					<label>Profile Pic</label>
					<span class="datainfo"> <a class="example-image-link" href=""  data-lightbox="example-1" id="ppic" data-title="profile picture"><img  class="example-image" alt="image" id="prpic"
				src="" width="100" height="100" /></a>
			</span>
					<a href="#" class="editlink" id="imgclick">Edit Info</a>
					<a class="savebtn" id="imgsave">Save</a>
				</div>
			</div>
		</section>
	</div>

















		</form:form>
	</div>
</body>
</html>