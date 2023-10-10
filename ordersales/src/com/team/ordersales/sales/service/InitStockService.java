package com.team.ordersales.sales.service;

import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.sales.dao.StockInfoDao;

public class InitStockService {
	public void initStock(HttpServletRequest req) {
		StockInfoDao.initStock();
		
		req.setAttribute("pageurl", "/displaystock");
	}

}
