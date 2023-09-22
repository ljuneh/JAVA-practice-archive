<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
	<%
		for(int i =0; i<= 5; i++) {
			out.println("<br>숫자: " + i);
		}
	%>
</body>
</html>