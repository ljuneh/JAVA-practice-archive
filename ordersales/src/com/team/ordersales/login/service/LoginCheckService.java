package com.team.ordersales.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.team.ordersales.login.dao.LoginCheckDao;

public class LoginCheckService {
	
	public void loginCheck(String sParaId, String sParaPassword, HttpServletRequest req) {
		
		
		if(LoginCheckDao.loginCheck(sParaId, sParaPassword)) {
			req.setAttribute("pageurl", "/displaygoods");
			HttpSession session = req.getSession(true);
			String id = (String) session.getAttribute("id");
			if(id == null) {
				id = sParaId;
				session.setAttribute("id", id);
			}
			
		} else {
			req.setAttribute("pageurl", "/login/registermember.jsp");
			req.setAttribute("id", sParaId);
			req.setAttribute("password", sParaPassword);
		}
		
	}
	
	public void sessionCheck(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String id = (String) session.getAttribute("id");
		String headermsg = "로그인";
		
		if(id!=null) {
			headermsg = id + " 로그아웃";
		}
		
		req.setAttribute("headermsg", headermsg);
		
	}

}
