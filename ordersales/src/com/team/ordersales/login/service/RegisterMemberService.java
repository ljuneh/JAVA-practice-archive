package com.team.ordersales.login.service;

import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.login.dao.RegisterMemberDao;
import com.team.ordersales.login.dto.RegisterMemberDto;

public class RegisterMemberService {
	
	public void registerMember(RegisterMemberDto registerMemberDto, HttpServletRequest req) {
		if(RegisterMemberDao.regiMember(registerMemberDto)) {
			req.setAttribute("pageurl", "/login/loginsuccess.jsp");
		} else {
			req.setAttribute("pageurl", "login/registerfail.jsp");
			req.setAttribute("id", registerMemberDto.getId());
			req.setAttribute("message", "register fail");
		}
	}

}
