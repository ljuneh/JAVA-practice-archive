<%@ page language="java" contentType="text/html; charset=UTF-8"/
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/springmvc_ctrl/outputUser">
		<pre>
			id : <input type="text" name="id">
			name : <input type="text" name="name">
			salary : <input type="text" name="salary">
			<input type="submit" value="submit">
		</pre>
	</form>
	
	<br>
	<p>inputed id : ${id}</p>
	<p>inputed name : ${name}</p>
	<p>inputed salary : ${salary}</p>
</body>
</html>