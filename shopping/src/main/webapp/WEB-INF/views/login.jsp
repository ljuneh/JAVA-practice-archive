<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link rel="stylesheet" href="resources/CSS/login.css">
    
</head>

<body>
    <div class="container">
        <h2>Login Form</h2>
        <form:form modelAttribute="loginDto" action="/shopping/login" method="POST">
            <label for="id"><b>Username</b></label>
        	<input type="text" placeholder="아이디" class="in" name = "id" required>

            <label for="password"><b>Password</b></label>
        	<input type="password" placeholder="비밀번호" class="in" name = "password" required>
            
            <form:errors path="*" cssClass="formerror"/>
            <button type="submit">Login</button>
        </form:form>
        <a href="/shopping/registerpage"><button>register</button></a>
        <button onclick="history.back()">Back</button>
    </div>
</body>

</html>