package com.team.ordersales.display.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.display.dao.DisplayStockDao;
import com.team.ordersales.display.dto.StockInfoDto;

public class DisplayStockService {
	public void retStock(HttpServletRequest req) {
		ArrayList<StockInfoDto> stockInfoDtoArr = DisplayStockDao.retStockInfoDto();
		
		req.setAttribute("stockInfoArr", stockInfoDtoArr);
		req.setAttribute("pageurl", "/display/admin.jsp");
		
	}

}
