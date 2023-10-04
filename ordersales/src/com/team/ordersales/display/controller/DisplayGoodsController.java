package com.team.ordersales.display.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.ordersales.display.service.DisplayGoodsService;
import com.team.ordersales.display.utils.ServletForward;

@WebServlet("/displaygoods")
public class DisplayGoodsController extends HttpServlet { 
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		new DisplayGoodsService().retGoods(req);
		
		new ServletForward().pageForward(req, resp);
		String link = "https://step-by-step-noah.tistory.com/84";
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
