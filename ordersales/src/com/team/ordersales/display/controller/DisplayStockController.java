package com.team.ordersales.display.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.ordersales.display.service.DisplayStockService;
import com.team.ordersales.display.utils.ServletForward;
import com.team.ordersales.login.service.LoginCheckService;

@WebServlet("/displaystock")
public class DisplayStockController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		new LoginCheckService().sessionCheck(req);
		
		new DisplayStockService().retStock(req);
		
		new ServletForward().pageForward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
