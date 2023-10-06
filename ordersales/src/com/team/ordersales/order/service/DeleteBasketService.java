package com.team.ordersales.order.service;

import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.order.dao.OrderToBasketDao;

public class DeleteBasketService {
	
	public void deleteGoodsInBasket(int seq, HttpServletRequest req) {
		
		int iRet = OrderToBasketDao.updateConfirmedBySeq(seq, "C");
		
		
		req.setAttribute("pageurl", "/displaybasket");
	}

}
