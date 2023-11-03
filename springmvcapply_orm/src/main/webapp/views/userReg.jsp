<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="registerUser">
		<pre>
			id: <input type="text" name="id" />
			password: <input type="text" name="password" />
			name: <input type="text" name="name" />
			email: <input type="text" name="email" />
			address: <input type="text" name="address" />
			<input type="submit" name="register" />
		</pre>
	</form>
	
	<br>
	${result}

</body>
</html>