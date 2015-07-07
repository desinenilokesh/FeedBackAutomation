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
<!-- Style sheets -->
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/style.css"/>" media="screen" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/BootStrapTimePicker.css"/>"
	media="screen" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.1/css/datepicker.css">
<!-- Java Script -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script
	src="http://jdewit.github.io/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.1/js/bootstrap-datepicker.js"></script>
<script>
	$(function() {
		var date = new Date();
		date.setDate(date.getDate());
		$("#sdate").datepicker({
			startDate : date,
			format : "dd/mm/yyyy"
		});
	});
	$(function() {
		$('#startTime').timepicker();
		
		
	});
	$(function() {
		$('#endTime').timepicker();
	});
	
	
	
	
	
/* 
     $("#endTime").change(function () {
    	 alert('hi');
         var startTime = document.getElementById("startTime").value;
        var endTime = document.getElementById("endTime").value;

        if ((Date.parse(endTime) <= Date.parse(startTime))) {
         alert("End time should be greater than Start time");
        document.getElementById("startTime").value = "";
} });
	 */
	
	
	
	
	
	
	
	
	function reset() {
		document.getElementById("startTime").value = "";
		document.getElementById("endTime").value = "";
		document.getElementById("sdate").value = "";
	}

	function callTechAjax() {
		var technology = document.getElementById("Technology").value;
		document.getElementById("topic").disabled = false;
		document.getElementById("defaulttopic").defaultSelected = true;
		document.getElementById('topic').options.length = 1;

		$.ajax({
			url : '${pageContext.request.contextPath}/Admin/gettopics',
			method : 'GET',
			data : {
				tech : technology
			},
			datatype : "json",
			contentType : 'application/json',
			success : function(data) {
				processdata(data);
			},
			error : function() {
				alert('error')
			}

		});

	}

	function callTopAjax() {

		document.getElementById("trname").disabled = false;
		document.getElementById("defaulttrainer").defaultSelected = true;
		document.getElementById('trname').options.length = 1;

		var topic = document.getElementById("topic").value;
		$.ajax({
			url : '${pageContext.request.contextPath}/Admin/gettid',
			method : 'GET',
			data : {
				tname : topic
			},
			datatype : "json",
			contentType : 'application/json',
			success : function(data) {
				document.getElementById("tid").value = data;

				callGetTrainersAjax(data);

			},
			error : function() {
				alert('error')
			}

		});
	}

	function callGetTrainersAjax(data) {
		$.ajax({
			url : '${pageContext.request.contextPath}/Admin/getrnames',
			method : 'GET',
			data : {
				tid : data
			},
			datatype : "json",
			contentType : 'application/json',
			success : function(trdata) {
				processTrnames(trdata);
			},
			error : function() {
				alert('error')
			}

		});
	}

	function callTrAjax() {

		var tname = document.getElementById("trname").value;

		$.ajax({
			url : '${pageContext.request.contextPath}/Admin/gettrid',
			method : 'GET',
			data : {
				trainername : tname
			},
			datatype : "json",
			contentType : 'application/json',
			success : function(data) {
				document.getElementById("trid").value = data;

			},
			error : function() {
				alert('error')
			}

		});
	}

	function processdata(data) {
		for (var i = 0; i < data.length; i++) {

			var x = document.getElementById("topic");
			var option = document.createElement("option");
			option.text = data[i];
			x.add(option);
		}
	}

	function processTrnames(trdata) {

		var x = document.getElementById("trname");

		for (var i = 0; i < trdata.length; i++) {
			var option = document.createElement("option");
			option.text = trdata[i];
			x.add(option);
		}
	}
	function checktime()
	{
	
		
		alert('hi');
		var starttime=document.getElementById("startTime").value;
		var endtime=document.getElementById("endTime").value;
		alert(starttime.indexOf("AM"));
		var startvalue,endvalue;
		var flag=true;
		if(starttime.indexOf("AM")>-1)
			{
			startvalue=  parseInt(starttime.substring(0,starttime.indexOf(':'))*100 )+ parseInt(starttime.substring(starttime.indexOf(':')+1,starttime.indexOf(':')+3));
			}
		else
			{
			 startvalue=  parseInt((parseInt(starttime.substring(0,starttime.indexOf(':')))+12)*100)+ parseInt(starttime.substring(starttime.indexOf(':')+1,starttime.indexOf(':')+3));
			
			}
		if(endtime.indexOf("AM")>-1)
			{
			endvalue=parseInt(endtime.substring(0,endtime.indexOf(':'))*100 )+ parseInt(endtime.substring(endtime.indexOf(':')+1,endtime.indexOf(':')+3));
			}
		else
			{
			endvalue=  parseInt((parseInt(endtime.substring(0,endtime.indexOf(':')))+12)*100)+ parseInt(endtime.substring(endtime.indexOf(':')+1,endtime.indexOf(':')+3));
			
			}
		
		
		alert(startvalue);
		alert(endvalue);
		if(startvalue<900)
			{
			alert("in starttime<900");
			document.getElementById("Technology").selectedIndex =0;
			document.getElementById("topic").selectedIndex =0;
			document.getElementById("trname").selectedIndex =0;
			document.getElementById("topic").disabled = true;
			document.getElementById("trname").disabled = true;
			document.getElementById("stimeerror").innerHTML="please select time time after 9.00 A.M";
			flag=false;
			}
		else
			{
			document.getElementById("stimeerror").innerHTML="";
			}
		 if(endvalue>1800)
			{
			 document.getElementById("Technology").selectedIndex =0;
				document.getElementById("topic").selectedIndex =0;
				document.getElementById("trname").selectedIndex =0;
				document.getElementById("topic").disabled = true;
				document.getElementById("trname").disabled = true;
			 alert("in endtime>1800");
			 document.getElementById("Technology").selectedIndex =0;
			document.getElementById("timeerror").innerHTML="please select time time before 6.00 P.M"
			flag=false;
			}
		 else
			 {
			 document.getElementById("timeerror").innerHTML=""
			 }
		if(startvalue>900 && endvalue<1800)
		{
			if(endvalue-startvalue>300)
			{
			document.getElementById("timeerror").innerHTML="Session should not last more than 3 hrs";
			flag=false;
			}
		else
			{
			if(endvalue<startvalue)
			{
				document.getElementById("Technology").selectedIndex =0;
				document.getElementById("topic").selectedIndex =0;
				document.getElementById("trname").selectedIndex =0;
				document.getElementById("topic").disabled = true;
				document.getElementById("trname").disabled = true;
				alert("in end <start");
			document.getElementById("Technology").selectedIndex =0;
			alert('please select appropriate Times');
			document.getElementById("timeerror").innerHTML="please select time time after"+starttime;
			flag=false;
			}
		else
			{
			document.getElementById("timeerror").innerHTML="";
			}
			}
			
			
		}
		if(flag)
			{
			 document.getElementById("addsessionform").submit();
			}
		
		
		
	}

	
	
</script>


<script>
	
</script>

</head>
<body style="padding-left: 20%; padding-right: 20%" onload="reset();">

	<%@ include file="Top.jsp"%>
	<p>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
	<form:form id="addsessionform" modelAttribute="sessionform"
		commandName="sessionform" action="sessionadding">
		<div align="center">

			<table align="center" style="border-spacing: 10px;">
				<tr>
					<td colspan="2"><h1 align="center" style="font-size: 35px">Adding
							Session</h1></td>
				</tr>
				<tr>

					<td><label>Date</label></td>
					<td><form:input path="sdate" id="sdate"
							placeholder="dd/mm/yyyy" />
						<form:errors style="color: red;font-style: italic;" path="sdate" /></td>
				</tr>
				<tr>
					<td>
						<h3>
							<label>Start Time</label>
						</h3>
					</td>
					<td>
						<div class="input-append bootstrap-timepicker">
							<form:input path="startTime" type="text" name="startTime"
								id="startTime" class="class=input-small" placeholder="HH:MM" />
							<span class="add-on"><i class="icon-time"></i></span>
						</div> <form:errors style="color: red;font-style: italic;"
							path="startTime" /><span id="stimeerror" style="color: red"></span>

					</td>

				</tr>

				<tr>
					<td><h3>
							<label>End Time</label>
						</h3></td>
					<td><div class="input-append bootstrap-timepicker">
							<form:input path="endTime" type="text" name="endTime"
								id="endTime" placeholder="HH:MM"/>
							<span class="add-on"><i class="icon-time"></i></span>
						</div>
						<form:errors style="color: red;font-style: italic;" path="endTime"/><span id="timeerror" style="color: red"></span></td>
				</tr>

				<tr>
					<td><label>Select Technology</label></td>
					<td><form:select path="Technology" id="Technology"
							onChange="callTechAjax();">
							<option value="" id="defaultechnology">--Select Technology</option>
							<form:options items="${technologies}" />
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="Technology" /></td>
				</tr>
				<tr>
					<td><h3>
							<label>Topic</label>
						</h3></td>
					<td><select id="topic" name="topic" onChange="callTopAjax();"
						disabled="true">
							<option value="" id="defaulttopic">--Select Topic</option>
							<%-- <form:option value="">--Select topic</form:option> --%>
							<%-- 	 <form:options items="${topiclist}" /> 
 --%>
							<select>
								<form:errors style="color: red;font-style: italic;" path="topic" /></td>

				</tr>

				<tr>
					<td><h3>
							<label>Trainer Name</label>
						</h3></td>
					<td><form:select path="trainerName" id="trname"
							onChange="callTrAjax();" disabled="true">
							<form:option value="" id="defaulttrainer">--Select Trainer</form:option>
							<form:options items="${trainers}" />
						</form:select> <FONT color="red"><form:errors path="trainerName" /></FONT></td>
				</tr>


				<tr>
					<td colspan="2"><input type="button" name="addsession" id="addsession"
						value="AddSession" align="center" onclick="checktime()"/></td>
				</tr>
				<tr>
					<td><form:hidden path="trid"></form:hidden></td>
				</tr>

				<tr>
					<form:hidden path="tid"></form:hidden>
				</tr>



			</table>
		</div>
		<div id="msg" align="center">
			<h1 style="color: green;">${message}</h1>
		</div>
	</form:form>
	<p>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
	<%@ include file="bottom.jsp"%>
</body>
</html>