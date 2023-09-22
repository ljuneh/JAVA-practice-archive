<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>jspserver</title>
    </head>
    <body>
    
        <p> <%= request.getParameter("firstName") %> </p>
        <p> <%= request.getParameter("lastName") %> </p>
    
    </body>
    </html>