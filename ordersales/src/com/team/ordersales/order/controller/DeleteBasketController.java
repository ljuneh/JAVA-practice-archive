package com.team.ordersales.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.ordersales.display.utils.ServletForward;
import com.team.ordersales.login.service.LoginCheckService;
import com.team.ordersales.order.service.DeleteBasketService;

@WebServlet("/deletebasket")
public class DeleteBasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		int seq = Integer.parseInt(req.getParameter("seq"));
		
		
		new LoginCheckService().sessionCheck(req);
		
		new DeleteBasketService().deleteGoodsInBasket(seq, req);
		
		new ServletForward().pageForward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
