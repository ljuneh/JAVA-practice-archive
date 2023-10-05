package com.team.ordersales.display.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.display.dao.DisplayGoodsDao;
import com.team.ordersales.display.dto.InsalesGoodsDto;
import com.team.ordersales.display.entity.InsalesGoodsEntity;

public class DisplayGoodsService {
	public void retGoods(HttpServletRequest req) {
		ArrayList<InsalesGoodsEntity> insalesGoodsEntityArr = DisplayGoodsDao.retInsalesGoodsEntity();
		
		ArrayList<InsalesGoodsDto> insalesGoodsDtoArr = new ArrayList<>();
		
		for(InsalesGoodsEntity insalesGoodsEntity : insalesGoodsEntityArr) {
			int quantity = DisplayGoodsDao.retCurrentRawQuantity(insalesGoodsEntity.getGoodsCode());
			
			InsalesGoodsDto insalesGoodsDto = new InsalesGoodsDto();
			
			insalesGoodsDto.setGoodsCode(insalesGoodsEntity.getGoodsCode());
			insalesGoodsDto.setGoodsName(insalesGoodsEntity.getGoodsName());
			insalesGoodsDto.setPrice(insalesGoodsEntity.getPrice());
			insalesGoodsDto.setRawmaterialquantity(insalesGoodsEntity.getRawMaterialQuantity());
			insalesGoodsDto.setCurrentrawquantity(quantity);
			
			insalesGoodsDtoArr.add(insalesGoodsDto);
		}
		
		req.setAttribute("insalesGoodsArr", insalesGoodsDtoArr);
		req.setAttribute("pageurl", "/display/market.jsp");
	}

}
