package com.team.ordersales.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.ordersales.login.utils.ServletForward;
import com.team.ordersales.order.dto.OrderToBasketDto;


@WebServlet("/ordergoods")
public class OrderToBasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String code = req.getParameter("code");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String quantity = req.getParameter("quantity");
		String raw = req.getParameter("raw");
		String current = req.getParameter("current");
		String totalprice = req.getParameter("totalprice");
		
		OrderToBasketDto orderToBasketDto = new OrderToBasketDto(code, name, price, quantity, raw, current, totalprice);
		
		
		new ServletForward().pageForward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
