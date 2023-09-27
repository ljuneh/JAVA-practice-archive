package com.team.ordersales.login.service;

import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.login.dao.LoginCheckDao;

public class LoginCheckService {
	
	public void loginCheck(String sParaId, String sParaPassword, HttpServletRequest req) {
		if(LoginCheckDao.loginCheck(sParaId, sParaPassword)) {
			req.setAttribute("pageurl", "/login/loginsuccess.jsp");
			req.setAttribute("id", sParaId);
		} else {
			req.setAttribute("pageurl", "/login/registermember.jsp");
			req.setAttribute("id", sParaId);
			req.setAttribute("password", sParaPassword);
		}
		
	}

}
