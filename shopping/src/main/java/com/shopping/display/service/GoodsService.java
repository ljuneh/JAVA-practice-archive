package com.shopping.display.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shopping.display.dao.DisplayDao;
import com.shopping.display.dto.InsalesGoodsDto;
import com.shopping.login.dao.UserInfoRepository;
import com.shopping.login.entity.UserInfo;
import com.shopping.order.dao.OrderInfoRepository;
import com.shopping.order.dto.OrderInfoDto;
import com.shopping.order.entity.OrderInfo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GoodsService {
	
	private final DisplayDao displayDao;
	
	private final OrderInfoRepository orderInfoRepository;
	private final UserInfoRepository userInfoRepository;
	
	public List<InsalesGoodsDto> retDisplayList() {
		List<InsalesGoodsDto> insalesList = null;
		
		insalesList = displayDao.retInsalesGoodsDtoList();
		
		
		return insalesList;
	}
	
	public List<InsalesGoodsDto> retSearchList(String name) {
		List<InsalesGoodsDto> insalesList = null;
		
		insalesList = displayDao.retsearchedGoodsDtoList(name);
		
		
		return insalesList;
	}
	
	public List<OrderInfoDto> retBasketList(String id, String confirmed) {
		List<OrderInfo> basketList = null;
		List<OrderInfoDto> basketDtoList = new ArrayList<OrderInfoDto>();
		
		
		UserInfo userInfo = userInfoRepository.getReferenceById(id);
		
		basketList = orderInfoRepository.findAllByUserInfoAndConfirmedOrderByOrderSeqAsc(userInfo, confirmed);
		
		for(OrderInfo orderInfo : basketList) {
			OrderInfoDto orderInfoDto = new OrderInfoDto();
			
			orderInfoDto.setSeq(orderInfo.getOrderSeq());
			orderInfoDto.setGoodsName(orderInfo.getOrderGoods().getGoodsName());
			orderInfoDto.setPrice(orderInfo.getOrderGoods().getPrice());
			orderInfoDto.setOrderQuantity(orderInfo.getOrderQuantity());
			orderInfoDto.setOrderDate(orderInfo.getOrderDate());
			
			int totalPrice = orderInfoDto.getPrice()*orderInfoDto.getOrderQuantity();
			orderInfoDto.setTotalPrice(totalPrice);
			
			basketDtoList.add(orderInfoDto);
		}
		
		
		return basketDtoList;
	}
	

}
