<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/style.css"/>" media="screen" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/UserMenu.css"/>" media="screen" />
</head>
<body>
	<ul class="sonarmenu">
		<li><a style='text-decoration:underline !important;'
			href="${pageContext.servletContext.contextPath}/Trainee/editprofileview">Edit Profile</a></li>
		<li><a style='text-decoration:underline !important;'
			href="${pageContext.servletContext.contextPath}/Trainee/changepasswordview">Change Password</a></li>
		<%-- <li><a
			href="${pageContext.servletContext.contextPath}/Admin/ViewFeedBack">View
				FeedBack</a></li> --%>
		<li><a style='text-decoration:underline !important;'
			href="${pageContext.servletContext.contextPath}/Trainee/logout">Logout</a></li>
	</ul>

</body>
</html>