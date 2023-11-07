package com.shopping.display.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.display.dto.InsalesGoodsDto;
import com.shopping.display.service.GoodsService;
import com.shopping.login.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DisplayController {
	private final UserService userService;
	private final GoodsService goodsService;
	
	@RequestMapping("/displayinsales")
	public String displayInsalesGoods(HttpServletRequest request, ModelMap modelMap) {
		
		userService.sessionCheck(request, modelMap);
		
		List<InsalesGoodsDto>insalesDtoList = goodsService.retDisplayList();
		modelMap.addAttribute("insalesDtoList", insalesDtoList);
		for(InsalesGoodsDto insalesDto: insalesDtoList) {
			System.out.println(insalesDto);
		}
		return "market";
	}
}
