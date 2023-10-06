package com.team.ordersales.order.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.team.ordersales.order.dao.OrderToBasketDao;
import com.team.ordersales.order.dto.OrderToBasketDto;

public class OrderToBasketService {
	
	public void orderGoods(OrderToBasketDto orderToBasketDto, HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String id = (String) session.getAttribute("id");
		
		int iRet = 0;
		
		if(id==null) {
			req.setAttribute("pageurl", "/login/login.jsp");
			return;
		} else {
			iRet = OrderToBasketDao.insertOrderInfo(orderToBasketDto, id);
			
		}
		
		if(iRet >0) {
			req.setAttribute("pageurl", "/displaygoods");
		}
	}

}
