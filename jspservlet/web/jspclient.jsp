<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>jspclient</title>
    </head>
    <body>
    
        <form action="/jspserver.jsp" method="get">
            First Name: <input type="text" name="firstName"> <br>
            Last Name: <input type="text" name="lastName"> <br>

            Country: <select name="country" id="">
                <option value="Brazil">Brazil</option>
                <option value="France">France</option>
                <option value="Germany">Germany</option>
                <option value="India">India</option>
                <option value="Turkey">Turkey</option>
                <option value="United Kingdom">United Kingdom</option>
                <option value="United States">United States</option>
            </select> <br>
            Favorite Programming Langauge: <br>
            <input type="radio" name="favoriteLanguage" value="Java">Java
            <input type="radio" name="favoriteLanguage" value="C#">C#
            <input type="radio" name="favoriteLanguage" value="PHP">PHP
            <input type="radio" name="favoriteLanguage" value="Ruby">Ruby
            CheckBox example <br>
            <input type="checkbox" name="checkboxexample" value="checkbox1">checkbox1
            <input type="checkbox" name="checkboxexample" value="checkbox2">checkbox2
            <input type="checkbox" name="checkboxexample" value="checkbox3">checkbox3
            <input type="checkbox" name="checkboxexample" value="checkbox4">checkbox4
            <input type="submit" value="submit">
        </form>
    
    </body>
    </html>