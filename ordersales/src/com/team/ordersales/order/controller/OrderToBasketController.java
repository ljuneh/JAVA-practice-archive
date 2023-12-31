package com.team.ordersales.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.ordersales.login.utils.ServletForward;
import com.team.ordersales.order.dto.OrderToBasketDto;
import com.team.ordersales.order.service.OrderToBasketService;


@WebServlet("/ordergoods")
public class OrderToBasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String code = req.getParameter("code");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		OrderToBasketDto orderToBasketDto = new OrderToBasketDto(code, quantity);
		
		new OrderToBasketService().orderGoods(orderToBasketDto, req);
		
		
		new ServletForward().pageForward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
