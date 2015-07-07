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
<link rel="stylesheet"
	href="<c:url value="/resources/css/jquery-ui.css"/>">
<script src="<c:url value="/resources/js/jquery-1.9.1.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
<%-- <script src="<c:url value="/resources/js/jquery.min.js"/>"></script> --%>

	<script>
	function callTechAjax() {
		alert('hello');
		var technology = document.getElementById("technology").value;
		 document.getElementById("topic").disabled=false;
		alert(technology);
		$.ajax({
			url : '${pageContext.request.contextPath}/Admin/gettopics',
			method : 'GET',
			data : {
				tech : technology
			},
			datatype : "json",
			contentType : 'application/json',
			success : function(data) {
				//document.getElementById("sid").value = data;
				alert(data);
			/* 	var options='<option value="">Topic</option>';
				var len=data.length; */
				processdata(data);
				/* for(var i=0;i<len;i++)
					{
					
					 var x = document.getElementById("topic");
					    var option = document.createElement("option");
					    option.text = data[i];
					    x.add(option);
					
					
					
					/* options+='<option value="'+data[i]+'"></option>'; */
					//} 
				/* options+='</option>'; */
				//alert(options);
				/* document.getElementById("topic").html(options); */

			},
			error : function() {
				alert('error')
			}

		});
		
		
	}
	function processdata(data)
	{
		alert('hello');
		for(var i=0;i<data.length;i++)
		{
		
		 var x = document.getElementById("topic");
		    var option = document.createElement("option");
		    option.text = data[i];
		    x.add(option);
		}
	}
	function callTopAjax()
	{
		alert('hello222');
		
		 /* document.getElementById("trname").disabled=false; */
		var topic = document.getElementById("topic").value;
		alert(topic);
		$.ajax({
			url : '${pageContext.request.contextPath}/Admin/gettid',
			method : 'GET',
			data : {
				tname : topic
			},
			datatype : "json",
			contentType : 'application/json',
			success : function(data) {
				alert(data);
				document.getElementById("tid").value = data;

			},
			error : function() {
				alert('error')
			}

		});
	}
	/* function callTrAjax()
	{
		alert('hello333');
		
		var tname = document.getElementById("trname").value;
	
		alert(topic);
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
	} */
	
</script>
<!-- <script>
$(".commit").click(function(){
    $("msg").slideUp();
  });
</script> -->
</head>
<body style="padding-left: 20%;padding-right: 20%">
<%@ include file="Top.jsp"%>
<p>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
	<form:form id="addsessionform" modelAttribute="trainerform"
		commandName="trainerform" action="addingtrainer">
		<div align="center">
			<table align="center" style="border-spacing: 10px;">
				<tr>
					<td colspan="2"><h1 align="center" style="font-size: 35px">Adding
							Trainer</h1></td>
				</tr>
		<tr>
		<td>
		<label>Trainer Name</label>
		</td>
		<td>
		<form:input path="tname" type="text" name="tname"
							id="tname"/><form:errors style="color: red;font-style: italic;"
							path="tname" />
		</td>
		</tr>

				<tr>
					<td><label>Select Technology</label></td>
					<td><form:select path="technology" id="technology"
							onChange="callTechAjax();" >
							<form:option value="">--Select Technology</form:option>
							<form:options items="${technologies}" />
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="technology" /></td>
				</tr>
				<tr>
					<td><h3>
							<label>Topic</label>
						</h3></td>
					<td><select id="topic" name="topic" onChange="callTopAjax();" disabled="true">
							<option value="">--Select Topic</option>
							<%-- <form:option value="">--Select topic</form:option> --%>
							<%-- 	 <form:options items="${topiclist}" /> 
 --%>
							<select>
								<form:errors style="color: red;font-style: italic;" path="topic" /></td>

				</tr>
				<tr>
				<td>
				<label>Experience</label>
				</td>
				<td>
				<form:input path="exper"/> <form:errors style="color: red;font-style: italic;" path="exper" />
				</td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" name="commit"
						value="Sign Up" align="center" /></td>
				</tr>
			<%-- 	<tr>
				<td>
				<form:hidden path="trid"></form:hidden>
				</td>
				</tr> --%>
				
				<tr>
					<form:hidden path="tid"></form:hidden>
				</tr>



			</table>
		</div>
		<div id="msg" align="center"><h1 style="color: green;">${message1}</h1>
		</div>
	</form:form>
	<p>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
	<%@ include file="bottom.jsp"%>
</body>
</html>