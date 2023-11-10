package com.shopping.sales.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shopping.display.dao.InsalesGoodsRepository;
import com.shopping.display.dao.OrderGoodsRepository;
import com.shopping.display.entity.InsalesGoods;
import com.shopping.display.entity.OrderGoods;
import com.shopping.login.dao.UserInfoRepository;
import com.shopping.login.entity.UserInfo;
import com.shopping.order.dao.OrderInfoRepository;
import com.shopping.order.entity.OrderInfo;
import com.shopping.order.service.BasketService;
import com.shopping.sales.dao.SalesInfoRepository;
import com.shopping.sales.entity.SalesInfo;
import com.shopping.stock.dao.StockInfoRepository;
import com.shopping.stock.entity.StockInfo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SalesService {
	private final OrderInfoRepository orderInfoRepository;
	private final UserInfoRepository userInfoRepository;
	private final StockInfoRepository stockInfoRepository;
	private final OrderGoodsRepository orderGoodsRepository;
	private final SalesInfoRepository salesInfoRepository;
	private final InsalesGoodsRepository insalesGoodsRepository;
	
	private final BasketService basketService;
	
	public List<String> purchaseGoodsInBasket(String id) {
		UserInfo userInfo = userInfoRepository.getReferenceById(id);
		List<OrderInfo> basketList = orderInfoRepository.findAllByUserInfoAndConfirmedOrderByOrderSeqAsc(userInfo, "N");
		
		String goodsCode = "";
		int currentQuantity = 0;
		int usedQuantity = 0;
		List<String> msgList = new ArrayList<String>();
		
		
		for(OrderInfo orderInfo : basketList) {
			Optional<StockInfo> optionalStockInfo = stockInfoRepository.findById(orderInfo.getOrderGoods().getGoodsCode());
			goodsCode = orderInfo.getOrderGoods().getGoodsCode();
			if(!optionalStockInfo.isEmpty()) {
				currentQuantity = optionalStockInfo.get().getGoodsQuantity();
			}
		    usedQuantity = orderInfo.getOrderQuantity();
		    
		    if(currentQuantity >= usedQuantity) {
		    	StockInfo stockInfo = new StockInfo(goodsCode, currentQuantity-usedQuantity);
		    	stockInfoRepository.save(stockInfo);
		    	
		    	
		    	SalesInfo salesInfo = new SalesInfo();
		    	OrderGoods orderGoods = orderGoodsRepository.getReferenceById(goodsCode);
		    	
		    	salesInfo.setOrderGoods(orderGoods);
		    	salesInfo.setUserInfo(userInfo);
		    	salesInfo.setSalesQuantity(usedQuantity);
		    	
		    	salesInfoRepository.save(salesInfo);
		    	
		    	
		    	basketService.updateBasket(orderInfo.getOrderSeq(), "Y");
		    	
		    	String msg = String.format("상품이름 : %s %d개가 구매 완료되었습니다.", orderInfo.getOrderGoods().getGoodsName(), usedQuantity);
		    	msgList.add(msg);
		    	
		    	
		    } else {
		    	String msg = String.format("상품이름 : %s %d개가 재고 부족으로 구매를 실패했습니다.", orderInfo.getOrderGoods().getGoodsName(), usedQuantity);
		    	msgList.add(msg);
		    }
		    
		    
		    
		}
		
		return msgList;
	}
	
	public List<OrderGoods> retOrderGoodsList() {
		List<OrderGoods> orderGoodsList = orderGoodsRepository.findAll();
		
		return orderGoodsList;
	}
	
	public void updateGoods(OrderGoods orderGoods) {
		OrderGoods updateGoods =  orderGoodsRepository.save(orderGoods);
		
		InsalesGoods insalesGoods = new InsalesGoods();
		insalesGoods.setGoodsCode(updateGoods.getGoodsCode());
		insalesGoods.setGoodsName(updateGoods.getGoodsName());
		insalesGoods.setPrice(updateGoods.getPrice());
		
		insalesGoodsRepository.save(insalesGoods);
		
	}
	
	public void deleteGoods(String code) {
		orderGoodsRepository.deleteById(code);
		insalesGoodsRepository.deleteById(code);
	}

}
