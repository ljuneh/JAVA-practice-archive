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
        <p> the student is confirmed ${param.firstName} ${param.lastName} </p>
        <p> in ${param.country} </p>
        <p> The student's favorite programming language : ${param.favoriteLanguage} </p>
        <p> checkbox test list : ${param.favoriteLanguage} </p>
        <ul>
        	<%
					String[] checkboxList = request.getParameterValues("favoriteLanguage ");
					if (checkboxList != null) {
						for (String checkbox : checkboxList)
						{
							out.println("<li>" + checkbox + "</li>");
						}
					}
				%>
        </ul>
    
    </body>
    </html>