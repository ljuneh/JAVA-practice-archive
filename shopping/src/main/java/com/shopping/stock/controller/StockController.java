package com.shopping.stock.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shopping.login.service.UserService;
import com.shopping.stock.dto.StockInfoDto;
import com.shopping.stock.entity.StockInfo;
import com.shopping.stock.service.StockService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StockController {
	private final UserService userService;
	private final StockService stockService;
	
	@RequestMapping("/stock")
	public String displayStock(HttpServletRequest request, ModelMap modelMap) {
		
		String id = userService.sessionCheck(request, modelMap);
		
		if(id==null) {
			return "login";
		}
		
		List<StockInfoDto> stockInfoDtoList = stockService.retStockInfoDtoList();
		
		modelMap.addAttribute("stockInfoDtoList", stockInfoDtoList);
		
		
		return "admin";
	}
	
	@RequestMapping("/updatestock")
	public String updateStock(@ModelAttribute("stockInfo") StockInfo stockInfo) {
		stockService.changeStockQuantity(stockInfo);
		
		return "redirect:/stock";
	}
	
	@RequestMapping("/initstock")
	public String initStock() {
		stockService.initStock(50);
		
		return "redirect:/stock";
	}

}
