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
</head>

<frameset rows="10%,84%">
<frame src="${pageContext.servletContext.contextPath}/FramesetViews/AdminMenu.jsp" name="top">
<frame src="${pageContext.servletContext.contextPath}/FramesetViews/AdminFrame.jsp" name="bottom">
</frameset>
<body>

</body>
</html>