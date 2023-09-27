package com.team.ordersales.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.ordersales.login.dto.RegisterMemberDto;
import com.team.ordersales.login.service.RegisterMemberService;

@WebServlet("/registermeber")
public class RegisterMemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		String addr = req.getParameter("addr");
		
		new RegisterMemberService().registerMember(new RegisterMemberDto(id, password, role, addr), req);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
