<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="sessionTest.jsp">
        add new item : <input type="text" name="theItem">
        <input type="submit" value="submit">
    </form>
    
    <%
    	List<String> items = (List<String>)session.getAttribute("todoList");
    	if(items == null) {
    		items = new ArrayList<String>();
    		session.setAttribute("todoList", items);
    	}
    	
    	String theItem = request.getParameter("theItem");
    	if((theItem!=null)&&(!theItem.equals(""))) {
    		items.add(theItem);
    	}
    	
    	for(String item : items) {
    		out.println("<li>"+ item + "</li>");
    	}
    
    %>

    <p>to do : ${param.theItem}</p>
</body>
</html>