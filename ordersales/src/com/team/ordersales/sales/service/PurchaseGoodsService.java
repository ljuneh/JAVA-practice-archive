package com.team.ordersales.sales.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.team.ordersales.display.dao.DisplayGoodsDao;
import com.team.ordersales.order.dao.DisplayBasketDao;
import com.team.ordersales.order.dao.OrderToBasketDao;
import com.team.ordersales.order.entity.OrderInfoEntity;
import com.team.ordersales.sales.dao.SalesInfoDao;
import com.team.ordersales.sales.dao.StockInfoDao;
import com.team.ordersales.sales.entity.SalesInfoEntity;

public class PurchaseGoodsService {
	
	public void purchaseGoodsInBasket(HttpServletRequest req) {
		
		HttpSession session = req.getSession(true);
		String id = (String) session.getAttribute("id");
		
		if(id==null) {
			req.setAttribute("pageurl", "/login/login.jsp");
			return;
		}
		
		ArrayList<OrderInfoEntity> orderInfoEntityArr = DisplayBasketDao.retOrderInfoEntity(id, "N");
		int rawQuantity = 0;
		int totalQuantity = 0;
		int currentQuantity = 0;
		
		for(OrderInfoEntity orderInfoEntity: orderInfoEntityArr) {
			String code = orderInfoEntity.getGoodsCode();
			rawQuantity = DisplayGoodsDao.retNeededRawQuantity(code);
			totalQuantity = rawQuantity*orderInfoEntity.getOrderQuantity();
			currentQuantity = DisplayGoodsDao.retCurrentRawQuantity(code);
			
			if(currentQuantity>=totalQuantity) {
				//stockinfo stock update
				StockInfoDao.updateStockInfoByGoodsCode(code, currentQuantity-totalQuantity);
				
				//salesinfo insert or update
				updatesQuantityInSalesInfo(orderInfoEntity);
				
				//change orderinfo's confirmed by "Y"
				OrderToBasketDao.updateConfirmedBySeq(orderInfoEntity.getSeq(), "Y");
				
			}
			
		}
		
		req.setAttribute("pageurl", "/displaygoods");
	}
	
	private void updatesQuantityInSalesInfo(OrderInfoEntity orderInfo) {
		SalesInfoEntity salesInfoEntity = SalesInfoDao.retSearchedSalesInfoByCode(orderInfo.getGoodsCode());
		int quantity = 0;
		if(salesInfoEntity == null) {
			SalesInfoDao.insertSalesInfo(orderInfo);
		} else {
			quantity = salesInfoEntity.getOrderQuantity();
			
			SalesInfoDao.updateSalesInfoByCode(orderInfo.getGoodsCode(), quantity+orderInfo.getOrderQuantity());
		}
	}

}
