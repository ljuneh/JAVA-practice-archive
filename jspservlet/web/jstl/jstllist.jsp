<%@page import="jstl.entity.Student"%>
<%@page import="java.util.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import ="jstl.entity.Student" %>

<%
	List<Student> data = new ArrayList<Student>();
	data.add(new Student("홍","길동", true));
	data.add(new Student("김","길동", false));
	data.add(new Student("이","길동", true));
	data.add(new Student("박","길동", false));
	data.add(new Student("선","길동", true));
	pageContext.setAttribute("myStudenet", data);
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 테스트</title>
</head>
<body>
	<c:forEach var="student" items="${myStudenet}">
		${student.firstName}
		${student.lastName}
		${student.goldCustomer}<br />
	</c:forEach>

</body>
</html>