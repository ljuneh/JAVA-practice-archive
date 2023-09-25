<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% String[] cities = {"city1", "city2", "city3"};
	pageContext.setAttribute("myCities", cities);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<c:set var="variable" value="<%= new Date() %>" />
	
	server time : ${variable}
	
	
	<c:forEach var="tempCity" items="${myCities}">
		${tempCity}
	</c:forEach>

</body>
</html>