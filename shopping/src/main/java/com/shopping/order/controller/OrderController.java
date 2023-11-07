package com.shopping.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.order.dao.OrderInfoRepository;
import com.shopping.order.entity.OrderInfo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {
	private final OrderInfoRepository orderInfoRepository;
	
	@RequestMapping("/ordertest")
	public String orderTest() {
		orderInfoRepository.save(new OrderInfo());
		
		
		return "redirect:/displayinsales";
	}
}
