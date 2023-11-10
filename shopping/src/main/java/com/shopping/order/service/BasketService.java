package com.shopping.order.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shopping.display.dao.OrderGoodsRepository;
import com.shopping.display.entity.OrderGoods;
import com.shopping.login.dao.UserInfoRepository;
import com.shopping.login.entity.UserInfo;
import com.shopping.order.dao.OrderInfoRepository;
import com.shopping.order.entity.OrderInfo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BasketService {
	
	private final OrderInfoRepository orderInfoRepository;
	
	private final UserInfoRepository userInfoRepository;
	
	private final OrderGoodsRepository orderGoodsRepository;
	
	public OrderInfo orderGoods(String id, String code, int quantity) {
		OrderInfo orderInfo = new OrderInfo();
		
//		orderInfo.setUserId(id);
//		orderInfo.setGoodsCode(code);
//		orderInfo.setOrderQuantity(quantity);
		
//		UserInfo userInfo = userInfoRepository.findById(id).orElseThrow(EntityNotFoundException::new); // findbyid로 일일이 select 호출 수 save
//		
//		OrderGoods orderGoods = orderGoodsRepository.findById(code).orElseThrow(EntityNotFoundException::new);
		
		UserInfo userInfo = userInfoRepository.getReferenceById(id);
		OrderGoods orderGoods = orderGoodsRepository.getReferenceById(code);
		
		
		
		orderInfo.setUserInfo(userInfo);
		orderInfo.setOrderGoods(orderGoods);
		orderInfo.setOrderQuantity(quantity);
		
		OrderInfo retOrderInfo =  orderInfoRepository.save(orderInfo);
		
		return retOrderInfo;
	}
	
	public void deleteGoodsInBasket(int seq) {
		OrderInfo orderInfo = orderInfoRepository.getReferenceById(seq);
		
		orderInfo.setConfirmed("C");
		
	}
	
	public void updateBasket(int seq, String confirmed) {
		OrderInfo orderInfo = orderInfoRepository.getReferenceById(seq);
		
		orderInfo.setConfirmed(confirmed);
	}

}
