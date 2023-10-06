package com.team.ordersales.order.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.team.ordersales.order.dao.DisplayBasketDao;
import com.team.ordersales.order.dto.DisplayBasketDto;
import com.team.ordersales.order.entity.OrderInfoEntity;

public class DisplayBasketService {
	
	public void retGoods(HttpServletRequest req) {
		
		HttpSession session = req.getSession(true);
		String id = (String) session.getAttribute("id");
		
		if(id==null) {
			req.setAttribute("pageurl", "/login/login.jsp");
			return;
		}
		
		ArrayList<OrderInfoEntity> orderInfoEntityArr = DisplayBasketDao.retOrderInfoEntity(id, "N");
		ArrayList<DisplayBasketDto> displayBasketDtoArr = new ArrayList<DisplayBasketDto>();
		
		String name = "";
		int price = 0;
		int quantity = 0;
		
		for(OrderInfoEntity orderInfoEntity: orderInfoEntityArr) {
			DisplayBasketDto displayBasketDto = new DisplayBasketDto();
			
			name = DisplayBasketDao.retGoodsNameByCode(orderInfoEntity.getGoodsCode());
			price = DisplayBasketDao.retPriceByCode(orderInfoEntity.getGoodsCode());
			quantity = orderInfoEntity.getOrderQuantity();
			
			
			
			displayBasketDto.setGoodsName(name);
			displayBasketDto.setSeq(orderInfoEntity.getSeq());
			displayBasketDto.setOrderQuantity(quantity);
			displayBasketDto.setOrderDate(orderInfoEntity.getOrderDate());
			displayBasketDto.setPrice(price);
			displayBasketDto.setTotalprice(price*quantity);
			
			displayBasketDtoArr.add(displayBasketDto);
		}
		
		req.setAttribute("displayBasketDtoArr", displayBasketDtoArr);
		req.setAttribute("pageurl", "/basket/basket.jsp");
	}

}
