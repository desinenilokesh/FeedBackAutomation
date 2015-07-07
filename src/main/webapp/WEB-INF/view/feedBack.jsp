
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form id="feedbackform" modelAttribute="sdform"
		commandName="sdform" action="${pageContext.request.contextPath}/FeedBack/submitfeedback">


 <div class="adjust" style='background-color: #FFF1F1'>
  <p>Consider the following criteria in giving feedback</p>
 <table cellpadding="0" cellspacing="15">

 <tr><td><label style='color: green;'>Excellent -</label></td><td><label style='color: maroon;'>10</label></td>
 <td><label style='color: green;'>Very Good -</label></td><td><label style='color: maroon;'>9</label></td>
 <td><label style='color: green;'>Good -</label></td><td><label style='color: maroon;'>7</label></td></tr>
 <tr><td><label style='color: green;'>Average -</label></td><td><label style='color: maroon;'>5</label></td>
 <td><label style='color: green;'>Poor -</label></td><td><label style='color: maroon;'>2</label></td>
 <td><label style='color: green;'>N.A -</label></td><td><label style='color: maroon;'>0</label></td></tr>
 </table>    
 </div>
 <br/>
   <hr>
    <br/>
  <table>
			<tr style='background: #FF66FF;font-weight: bold;'>
			<td><label>Select</label></td>
			<td><label>Session Id</label></td>
			<td><label>Trainer Name</label></td>
			<td><label>Topic Name</label></td>
			<td><label>Date</label></td>
			<td><label>Starting Time</label></td>
			<td><label>Ending Time</label></td>
			</tr>
			<br/>
			<tr style='background-color: #FFF1F1'>
			<td><input type="radio" checked="true"></td>
			<td>${sessionid}</td>
			<td>${trainername}</td>
			<td>${topicname}</td>
			<td>${startdate}</td>
			<td>${starttime}</td>
			<td>${endtime}</td>
			</tr>
			</table>
			<br/>
			<hr>
			<br/>
			<h1>${message}</h1>
<table border="0" cellpadding="2" cellspacing="5">
  <tr><td>  Coverage of content</td>
      <td>  <form:select path="rating[0]" id="ccrating">
							<form:option value="">--</form:option>
							<form:option value="10">10</form:option>
							<form:option value="9">9</form:option>
							<form:option value="7">7</form:option>
							<form:option value="5">5</form:option>
							<form:option value="2">2</form:option>
							<form:option value="0">0</form:option>
							
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="rating[0]" /></td></tr>
        
   <tr><td>    Quality of material provided </td>
     <td>   <form:select path="rating[1]" id="qrating">
							<form:option value="">--</form:option>
							<form:option value="10">10</form:option>
							<form:option value="9">9</form:option>
							<form:option value="7">7</form:option>
							<form:option value="5">5</form:option>
							<form:option value="2">2</form:option>
							<form:option value="0">0</form:option>
							
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="rating[1]" /></td></tr>
    <%-- <tr><td>  Relevance to your work</td>
<td>       <form:select path="rating[2]" id="wrating">
							<form:option value="">--</form:option>
							<form:option value="10">10</form:option>
							<form:option value="9">9</form:option>
							<form:option value="7">7</form:option>
							<form:option value="5">5</form:option>
							<form:option value="2">2</form:option>
							<form:option value="0">0</form:option>
							
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="rating[2]" /></td></tr>
<tr><td>        Your personal gain from the training</td>
  <td>       <form:select path="rating[3]" id="prating">
							<form:option value="">--</form:option>
							<form:option value="10">10</form:option>
							<form:option value="9">9</form:option>
							<form:option value="7">7</form:option>
							<form:option value="5">5</form:option>
							<form:option value="2">2</form:option>
							<form:option value="0">0</form:option>
							
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="rating[3]" /></td></tr>
 --%>   <tr><td>     Practical demonstration</td>
   <td>      <form:select path="rating[2]" id="prrating">
							<form:option value="">--</form:option>
							<form:option value="10">10</form:option>
							<form:option value="9">9</form:option>
							<form:option value="7">7</form:option>
							<form:option value="5">5</form:option>
							<form:option value="2">2</form:option>
							<form:option value="0">0</form:option>
							
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="rating[2]" /></td></tr>
   <tr><td>     Knowledge of Subject</td>
    <td>     <form:select path="rating[3]" id="krating">
							<form:option value="">--</form:option>
							<form:option value="10">10</form:option>
							<form:option value="9">9</form:option>
							<form:option value="7">7</form:option>
							<form:option value="5">5</form:option>
							<form:option value="2">2</form:option>
							<form:option value="0">0</form:option>
							
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="rating[3]" /></td></tr>
 <tr><td>        Clarity</td>
    <td>       <form:select path="rating[4]" id="ccrating">
							<form:option value="">--</form:option>
							<form:option value="10">10</form:option>
							<form:option value="9">9</form:option>
							<form:option value="7">7</form:option>
							<form:option value="5">5</form:option>
							<form:option value="2">2</form:option>
							<form:option value="0">0</form:option>
							
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="rating[4]" /></td></tr>
  <%-- <tr><td>      Style and delivary</td>
 <td>      <form:select path="rating[7]" id="krating">
							<form:option value="">--</form:option>
							<form:option value="10">10</form:option>
							<form:option value="9">9</form:option>
							<form:option value="7">7</form:option>
							<form:option value="5">5</form:option>
							<form:option value="2">2</form:option>
							<form:option value="0">0</form:option>
							
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="rating[7]" /></td></tr> --%>
  <tr><td>  Responsiveness to Group Producing and Group Learning</td>
    <td>     <form:select path="rating[5]" id="resrating">
							<form:option value="">--</form:option>
							<form:option value="10">10</form:option>
							<form:option value="9">9</form:option>
							<form:option value="7">7</form:option>
							<form:option value="5">5</form:option>
							<form:option value="2">2</form:option>
							<form:option value="0">0</form:option>
							
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="rating[5]" /></td></tr>
   <%-- <tr><td>    Answering Skills</td>
   <td>      <form:select path="rating[8]" id="asrating">
							<form:option value="">--</form:option>
							<form:option value="10">10</form:option>
							<form:option value="9">9</form:option>
							<form:option value="7">7</form:option>
							<form:option value="5">5</form:option>
							<form:option value="2">2</form:option>
							<form:option value="0">0</form:option>
							
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="rating[8]" /></td></tr>
     --%>    
<!--   <tr><td>     Overall Rating</td>
  <td>      <select type="text" value="" id="select11" name="select11">
            <option> </option>
            <option>10</option>
            <option>9</option>          
            <option>7</option>
            <option>5</option>
              <option>2</option>
            <option>0</option>
        </select></td></tr>
       
<tr><td>    OVERALL RATING OF THE TRAINING/WORKSHOP</td>
    <td>         <select type="text" value=" " id="select12" name="select12">
           <option> </option>
            <option>10</option>
            <option>9</option>          
            <option>7</option>
            <option>5</option>
              <option>2</option>
            <option>0</option>
        </select></td></tr> -->
 <tr><td>       ARRANGEMENTS OF THE VENUE</td>
    <td>      <form:select path="rating[6]" id="arrrating">
							<form:option value="">--</form:option>
							<form:option value="10">10</form:option>
							<form:option value="9">9</form:option>
							<form:option value="7">7</form:option>
							<form:option value="5">5</form:option>
							<form:option value="2">2</form:option>
							<form:option value="0">0</form:option>
							
						</form:select> <form:errors style="color: red;font-style: italic;"
							path="rating[6]" /></td></tr>
<tr><td>Suggestions for Improvement	</td>
<td><form:textarea rows="" cols="" path="suggestions"></form:textarea></td></tr>
         </table>
         <table>
<tr>
<td colspan="2"><input type="submit" value="Submit feedback"  align="middle"></td></tr>
</table>
</form:form>
</body>
</html>