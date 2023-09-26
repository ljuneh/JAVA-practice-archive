<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생정보</h2>
	<hr>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>성</th>
		</tr>
		<c:forEach var="student" items="${student_list}">
			<tr>
				<td>${student.sName}</td>
				<td>${student.sRegionType}</td>
			</tr>
	</c:forEach>
	</table>
</body>
</html>