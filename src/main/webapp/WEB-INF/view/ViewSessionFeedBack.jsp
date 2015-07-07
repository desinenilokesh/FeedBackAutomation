<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<h1 style="text-align: center;color: green;">Session FeedBack Report</h1>
	<table style="background: #E0F0FF;font-weight: bold;">
	<tr bordercolor="green">
	<th>EmpId</th>
	<th>SessionID</th>
	<th >Converag</th>
	<th > Quality</th>
	<th >Practical </th>
	<th>SubKnow</th>
	<th>Clarity</th>
	<th>Response</th>
	<th>Arrangements</th>
	<th>Suggestions</th>
	<th>Aggregate</th>
	
	</tr>
	<c:forEach items="${sessionfb}" var="sfb">
	<tr style='background-color: #FFF1F1'>
	<td style="text-align: center;">${sfb.empid}</td>
	 <td  style="text-align: center;">${sfb.sesid}</td> 
	<td  style="text-align: center;">${sfb.covcontent}</td> 
	<td style="text-align: center;">${sfb.matquality}</td> 
	<td  style="text-align: center;">${sfb.prac}</td> 
	<td  style="text-align: center;">${sfb.subknowl}</td> 
	<td  style="text-align: center;">${sfb.clarity}</td> 
	<td  style="text-align: center;">${sfb.responsive}</td> 
	<td  style="text-align: center;">${sfb.arrangements}</td> 
	<td style="text-align: center;">${sfb.suggestions}</td> 
	<td style="text-align: center;">${sfb.eagg}</td> 
 
</tr>
	
	</c:forEach>
	
		<tr style="background-color: #FFC266">
		<td colspan="10" style="text-align: left;">
		Total Aggregate 
		</td>
		<td style="text-align: center;">
		${TotalAgg}
		</td>
		</tr>
		</table>
</body>
</html>