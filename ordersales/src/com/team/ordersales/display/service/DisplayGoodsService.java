package com.team.ordersales.display.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.display.dao.DisplayGoodsDao;
import com.team.ordersales.display.dto.InsalesGoodsDto;

public class DisplayGoodsService {
	public void retGoods(HttpServletRequest req) {
		ArrayList<InsalesGoodsDto> insalesGoodsDtoArr = DisplayGoodsDao.retInsalesGoodsDto();
		
		req.setAttribute("insalesGoodsArr", insalesGoodsDtoArr);
		req.setAttribute("pageurl", "/display/market.jsp");
	}

}
