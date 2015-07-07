<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View FeedBack</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/SpotLightMenu.css"/>" media="screen" />
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/smoothness/jquery-ui.css" />

	<script>
	function getSessions()
	{
		$.ajax({
			url : '../FeedBack/getSessions',
			method : 'GET',
			contentType : 'application/text',
			success : function(data) {

				processdata(data);
			},
			error : function() {
				alert('error')
			}

		});
	}	
	function processdata(data)
	{
		/* var sess=data[0];
		aler(sess);
	var datas=JSON.parse(data);
	alert(datas+"in process");
		
		alert(datas.sessionid); */
		
		var sessiondata="";
		sessiondata+="<table width='80%'><tr style='background: #FF66FF; font-weight: bold;'><td><label>Select</label></td><td><label>Session Id</label></td><td><label>Trainer Name</label></td><td><label>Topic Name</label></td><td><label>Date</label></td><td><label>Starting Time</label></td><td><label>Ending Time</label></td></tr>";
		for(var j=0;j<data.length;j++)
			{
		//	alert(data[j]);
			
			//var jdata=JSON.parse(data[j]);
			
			sessiondata+="<tr style='background: #ADEBEB' id='tr_"+data[j].sessionid+"'><td><input type='radio' value='"+data[j].sessionid+"' id='sessionid' name='sessid' onchange='rchange(this);' /></td><td>"+data[j].sessionid+"</td><td style='text-transform: capitalize;'>"+data[j].trainername+"</td><td style='text-transform: capitalize;'>"+data[j].topicname+"</td><td>"+data[j].sdate+"</td><td>"+data[j].stime+"</td><td>"+data[j].etime+"</td></tr>";
			}
		document.getElementById("Sessionfeedback").innerHTML =sessiondata;
	}
	
	function rchange(control) {
		var value = control.value
		var rid = "tr_" + control.value;
		var x = document.getElementById(rid);
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
		var tag = $("<div></div>");
		$
				.ajax({

					url : '${pageContext.request.contextPath}/FeedBack/ViewSessionFeedback',
					data : {
						sessionid:sid,
						
					},
					success : function(data) {

						tag.html(data).dialog({
							modal : true,
							title : "FEEDBACK",
							width : 1024,
							height : 400
						}).dialog('open');

					}
				});

	}

	
	
	
	</script>
</head>
<body style="padding-left: 20%; padding-right: 20%"">
<%@ include file="Top.jsp"%>

<table class="spotlightmenu" align="center" >
<tr>
<td colspan="2">
<h2 style="text-align: center;text-decoration: underline;">ViewBy:</h2>
</td>
</tr>
<tr>
 <td><a href="javascript:void(0)" onclick="getSessions();"><span>Date<span></a></td> 
 <td><a href="#"><span>Trainer</span></a></td> 
 </tr>
 <tr>
 <td><a href="#"><span>Topic</span></a></td> 
 <td><a href="#"><span>Trainee</span></a></td> 
</tr>
</table>
<div id="Sessionfeedback" align="center">
	

		

</div>
<%@ include file="bottom.jsp"%>
</body>
</html>
