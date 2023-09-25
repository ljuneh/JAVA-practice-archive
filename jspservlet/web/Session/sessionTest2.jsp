<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.InsalesGoodsUserDAO"%>
<%@page import="jdbc.ShowInsalesEntity"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
    	List<ShowInsalesEntity> items = (List<ShowInsalesEntity>)session.getAttribute("showItemList");
    	if(items == null) {
    		items = new ArrayList<ShowInsalesEntity>();
    		session.setAttribute("showItemList", items);
    		
    	}
    	
    	String driver = "oracle.jdbc.driver.OracleDriver";
    	Class.forName(driver);
    	
    	if(items.isEmpty()) {
    		ArrayList<ShowInsalesEntity> showInsalesArr = InsalesGoodsUserDAO.retShowInsalesArr();
    		for(ShowInsalesEntity showInsales: showInsalesArr) {
    			items.add(showInsales);
    		}
    	}
   
    	
   
    	
    	session.setMaxInactiveInterval(60000);
    	
    	
    	
    	for(ShowInsalesEntity item : items) {
    		out.println("<li>"+ item.toString() +"test"+ "</li>");
    	}
    
    %>
</body>
</html>