package com.team.ordersales.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.ordersales.login.service.LoginCheckService;
import com.team.ordersales.login.utils.ServletForward;

@WebServlet("/logincheck")
public class LoginCheckController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sParaId = "";
		String sParaPassword = "";
		req.setCharacterEncoding("UTF-8");
		
		sParaId = req.getParameter("id");
		sParaPassword = req.getParameter("password");
		
		new LoginCheckService().loginCheck(sParaId, sParaPassword, req);
		
//		RequestDispatcher dispatcher =
//				req.getRequestDispatcher("/login/loginresult.jsp");
//		
//		dispatcher.forward(req, resp);
		new ServletForward().pageForward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
