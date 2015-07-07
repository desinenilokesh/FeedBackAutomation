

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.text.*,java.sql.Blob,java.io.*;"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.table {
	border: medium !important;
}
</style>
<link href="<c:url value='/resources/css/styles.css' />" type="text/css"
	rel="stylesheet" />
	<link href="<c:url value='/resources/css/lightbox.css' />" type="text/css"
	rel="stylesheet" />

<%-- <script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.js"/>"></script> --%>
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/lightbox.min.js"/>"></script>

<%-- <script src="<c:url value="/resources/js/jquery.query-2.1.7.js"/>"></script> --%>



<script src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/smoothness/jquery-ui.css" />








<script>
 $(function() {
    $( "feedback" ).dialog({
       autoOpen: false,  
    });
}); 
	function rchange(control) {
		var value = control.value
		var rid = "tr_" + control.value;
		var x = document.getElementById(rid);

		document.getElementById(value).disabled=true;
	
		var text = "";

		//gets cells of current row  
		var oCells = x.cells;
		//gets amount of cells of current row
		var cellLength = oCells.length;

		//loops through each cell in current row
		for (var j = 1; j < cellLength; j++) {

			// get your cell info here

			var cellVal = oCells.item(j).innerHTML;
			text += cellVal + "::";

		}
		var res = text.split("::");
		var sid=res[0];
		var trname = res[1];
		var toname = res[2];
		var sdate = res[3];
		var stime = res[4];
		var etime = res[5];
/* 		 $( "#feedback" ).dialog({
				modal : true,
				title : "FEEDBACK",
				width : 800,
				height : 800
			}).dialog('open'); */
	
		 var tag = $("<div></div>");
		$
				.ajax({

					url : '${pageContext.request.contextPath}/FeedBack/Showfeedbackform',
					data : {
						sessionid:sid,
						trainername : trname,
						topicname : toname,
						startdate : sdate,
						starttime : stime,
						endtime : etime
					},
					success : function(data) {

						tag.html(data).dialog({
							modal : true,
							title : "FEEDBACK",
							width : 800,
							height : 800
						}).dialog('open');

					}
				});

	}
 


	$(function() {
        $( "#accordion" ).accordion({
           collapsible: true
        });
     });
	
</script>

</head>
<body style="padding-left: 20%; padding-right: 20%">
	<%@ include file="TraineeTop.jsp"%>

	<br />
	<br />


	<form:form id="sessiondetailsform" modelAttribute="sdform"
		commandName="sdform" action="/FeedBack/FeedBackCalc">

		<div>
			<table width="100%">
				<tr>
					<td
						style='text-align: left; font-family: sans-serif; font-style: italic; border-bottom: thin; border-bottom-color: blue; color: green;'>
						<!-- <div style="float: right; "> --> <%
 	String loggedin = (String) session.getAttribute("loggedin");

 		if ((loggedin != null) && (loggedin.equals("yes"))) {
 			SimpleDateFormat sdf = new SimpleDateFormat(
 					"EEEE, dd MMMM yyyy");
 			String date = sdf.format(new Date());

 			out.println(date);
 %> <%
 	} else {
 			response.sendRedirect("login.jsp");
 		}
 %> <!-- 	</div> -->
					</td>
					<td
						style='text-align: right; font-style: italic; color: green; font-size: large; font-family: sans-serif;'>
						<!-- <span
		style="float: left; "> --> <%
 	String s = (String) session.getAttribute("username");
 		out.println("Welcome: " + s.toUpperCase());
 %> <!-- </span> -->
					</td>
						<td>
				<span style="float: right;"> <a class="example-image-link" href="data:image/jpeg;base64,${img}"  data-lightbox="example-1" id="ppic" data-title="profile picture"><img  class="example-image" alt="image" id="prpic"
				src="data:image/jpeg;base64,${img}" width="100" height="100" /></a>
			</span>
				</td>
				</tr>
				
			
				
			</table>
			
			</div>
		
			  <div id="accordion">
			   <h3>Previous Sessions</h3>
			   <div>
			
			<table width="80%" id="sdtable">
				<tr style='background: #FF66FF; font-weight: bold;'>
					<td><label>Select</label></td>
					<td><label>Session Id</label></td>
					<td><label>Trainer Name</label></td>
					<td><label>Topic Name</label></td>
					<td><label>Date</label></td>
					<td><label>Starting Time</label></td>
					<td><label>Ending Time</label></td>
				</tr>
				<c:if test="${empty prsessionlist}">
					<tr class="">
						<td colspan="7" style=" text-align: center;"><span style="color: red; ">Records
								Does not Exist</span></td>
					</tr>
				</c:if>


				<c:forEach items="${prsessionlist}" var="SessionDetails">


					<tr style='background: #ADEBEB' id="tr_${SessionDetails.sessionid}">
						<td><input type="radio" value='${SessionDetails.sessionid}'
							id="${SessionDetails.sessionid}" name="sessid" onchange="rchange(this);" /></td>
						<td>${SessionDetails.sessionid}</td>

						<td style='text-transform: capitalize;'>${SessionDetails.trainername}</td>
						<td style='text-transform: capitalize;'>${SessionDetails.topicname}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${SessionDetails.sdate}" /></td>
						<td>${SessionDetails.stime}</td>
						<td>${SessionDetails.etime}</td>

					</tr>

				</c:forEach>

			</table>
			<%-- 			<input type="submit" value="submit"
				onclick="javascript:popupDialog('<c:url value="/FeedBack/FeedBackCalc"/>','sessionDetails')" /> --%>
			<br />
		<!-- 	<div align="center">
				<input type="submit" value="submit" id="submitbtn"
					onclick="OpenPopup();" />
			</div> -->
			
			</div>
			 <h3>upcoming Sessions</h3>
			   <div>
			
			<table width="80%" id="sdtable">
				<tr style='background: #FF66FF; font-weight: bold;'>
					
			
					<td><label>Trainer Name</label></td>
					<td><label>Topic Name</label></td>
					<td><label>Date</label></td>
					<td><label>Starting Time</label></td>
					<td><label>Ending Time</label></td>
				</tr>
				<c:if test="${empty upsessionlist}">
					<tr class="">
						<td class="empty-data" colspan="7"><span class="r-mark">Records
								Does not Exist</span></td>
					</tr>
				</c:if>


				<c:forEach items="${upsessionlist}" var="upSessionDetails">


				
	

						<td style='text-transform: capitalize;'>${upSessionDetails.trainername}</td>
						<td style='text-transform: capitalize;'>${upSessionDetails.topicname}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${upSessionDetails.sdate}" /></td>
						<td>${upSessionDetails.stime}</td>
						<td>${upSessionDetails.etime}</td>

					</tr>

				</c:forEach>

			</table>
			</div>
			</div>
			<h1>${feedbackflagmsg }</h1>
			
				<%@ include file="bottom.jsp"%>
		
	</form:form>
	<!-- 	<div data-role="popup" id="sessionDetails"></div> -->
	<br/>
	
</body>
</html>