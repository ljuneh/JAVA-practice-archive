<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: #f7f7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 60%;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            background-color: #912568d2;
            color: white;
            cursor: pointer;
        }
        button:hover {
            background-color: #912568;
        }
        .back-button {
            background-color: rgba(29, 29, 29, 0.623);
        }
        .back-button:hover {
            background-color: rgb(29, 29, 29);
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Register</h2>
    <!-- <form id="registrationForm" action="/shopping/registration" method="POST">
        <div class="form-group">
            <label for="name">Username:</label>
            <input type="text" name="name" required>
        </div>
        <div class="form-group">
            <label for="id">id:</label>
            <input type="text" name="id" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="email">Email Address:</label>
            <input type="email" name="email" required>
        </div>
        <button type="submit">Register</button>
        <button type="button" class="back-button" onclick="history.back()">Back</button>
    </form> -->
    
    <form:form modelAttribute="registerDto" action="/shopping/registration" method="POST">
    	<div class="form-group">
            <form:label path="name">Username:</form:label>
            <form:input path="name" type="text" required="required"/>
        </div>
        <div class="form-group">
            <form:label path="id">id:</form:label>
            <form:input path="id" type="text" required="required"/>
            <form:errors path="id"></form:errors>
        </div>
        <div class="form-group">
            <form:label path="password">Password:</form:label>
            <form:input path="password" type="password" required="required"/>
        </div>
        <div class="form-group">
            <form:label path="email">Email Address:</form:label>
            <form:input path="email" type="email" required="required"/>
        </div>
        <button type="submit">Register</button>
        <button type="button" class="back-button" onclick="history.back()">Back</button>
    </form:form>
    
    
</div>

</body>
</html>
