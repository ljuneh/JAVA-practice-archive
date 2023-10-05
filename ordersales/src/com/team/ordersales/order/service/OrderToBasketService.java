package com.team.ordersales.order.service;

import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.order.dto.OrderToBasketDto;

public class OrderToBasketService {
	
	public void orderGoods(OrderToBasketDto orderToBasketDto, HttpServletRequest req) {
		
		
//		req.setAttribute("pageurl", "/displaygoods");
		req.setAttribute("pageurl", "/basket/test.jsp");
	}

}
