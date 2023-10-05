package com.team.ordersales.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginStateService {
	
	public void doServletByState(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String id = (String) session.getAttribute("id");
		
		if(id==null) {
			req.setAttribute("pageurl", "/login/login.jsp");
			
		} else {
			session.invalidate();
			req.setAttribute("pageurl", "/displaygoods");
		}
		
		
	}

}
