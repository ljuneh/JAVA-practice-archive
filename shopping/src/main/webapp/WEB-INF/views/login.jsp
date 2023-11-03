<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');

        * {
            font-family: 'Noto Sans KR', sans-serif;
        }

        body {
            background-color: #7a7a7a;
        }

        div {
            margin: auto;
            width: 300px;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }

        input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }

        .in {
            margin-bottom: 10px;
        }

        #btn {
            background-color: #1BBC9B;
            margin-bottom: 30px;
            color: white;
        }

        a {
            text-decoration: none;
            color: #9B9B9B;
            font-size: 12px;
        }
    </style>
</head>

<body>
    <div>
        <!-- <form action="/ordersales/logincheck" method="post">
            <input type="text" placeholder="아이디" class="in" name = "id">
            <input type="password" placeholder="비밀번호" class="in" name = "password">
            <input type="submit" id="btn" value="로그인"><br>
        </form> -->
        <a href="/ordersales/login/registermember.jsp">회원가입</a>
        <button onclick="history.back()">Back</button>
    </div>
</body>

</html>