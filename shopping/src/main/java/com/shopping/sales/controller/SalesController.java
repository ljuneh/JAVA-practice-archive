package com.shopping.sales.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopping.display.entity.OrderGoods;
import com.shopping.login.service.UserService;
import com.shopping.sales.service.SalesService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SalesController {
	private final UserService userService;
	private final SalesService salesService;
	
	@RequestMapping("/purchasegoods")
	public String purchaseGoods(HttpServletRequest request, ModelMap modelMap, RedirectAttributes redirectAtt) {
		String id = userService.sessionCheck(request, modelMap);
		List<String> msgList = salesService.purchaseGoodsInBasket(id);
		
//		modelMap.addAttribute("msgList", msgList);
		redirectAtt.addFlashAttribute("msgList", msgList);
		
		return "redirect:/displaybasket";
	}
	
	@RequestMapping("/goods")
	public String goodsManage(HttpServletRequest request, ModelMap modelMap) {
		String id = userService.sessionCheck(request, modelMap);
		
		if(id==null) {
			return "login";
		}
		
		List<OrderGoods> orderGoodsList = salesService.retOrderGoodsList();
		modelMap.addAttribute("orderGoodsList", orderGoodsList);
		
		return "goods";
	}
	
	@RequestMapping("/updategoods")
	public String updateGoods(@ModelAttribute("orderGoods") OrderGoods orderGoods) {
		salesService.updateGoods(orderGoods);
		
		return "redirect:/goods";
	}
	
	@RequestMapping("/deletegoods")
	public String deleteGoods(@RequestParam("deleteCode") String deleteCode) {
		salesService.deleteGoods(deleteCode);
		
		return "redirect:/goods";
	}

}
