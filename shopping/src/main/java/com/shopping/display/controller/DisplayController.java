package com.shopping.display.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shopping.display.dto.InsalesGoodsDto;
import com.shopping.display.service.GoodsService;
import com.shopping.login.service.UserService;
import com.shopping.order.dto.OrderInfoDto;
import com.shopping.order.entity.OrderInfo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DisplayController {
	private final UserService userService;
	private final GoodsService goodsService;
	
	@RequestMapping("/displayinsales")
	public String displayInsalesGoods(HttpServletRequest request, ModelMap modelMap) {
		
		userService.sessionCheck(request, modelMap);
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		
		String msg = null;
		if(flashMap != null){
			msg = (String)flashMap.get("msg");
		}
		
	    modelMap.addAttribute("msg", msg);
	    System.out.println("msg : "+msg);
	    
		
		List<InsalesGoodsDto>insalesDtoList = goodsService.retDisplayList();
		modelMap.addAttribute("insalesDtoList", insalesDtoList);
//		for(InsalesGoodsDto insalesDto: insalesDtoList) {
//			System.out.println(insalesDto);
//		}
		
		
		return "market";
	}
	
	@RequestMapping("displaybasket")
	public String displayBasket(HttpServletRequest request, ModelMap modelMap) {
		String id = userService.sessionCheck(request, modelMap);
		
		if(id==null) {
			return "redirect:/loginpage";
		}
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		
		List<String> msgList = null;
		if(flashMap != null){
			msgList = (List<String>)flashMap.get("msgList");
		}
		
	    modelMap.addAttribute("msg", msgList);
		
		List<OrderInfoDto> basketList = goodsService.retBasketList(id,"N");
		
		modelMap.addAttribute("displayBasketDtoList", basketList);
		
		
		return "basket";
	}
	
	@RequestMapping("search")
	public String searchGoodsByName(HttpServletRequest request, @RequestParam("searchName") String searchName, ModelMap modelMap) {
		userService.sessionCheck(request, modelMap);
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		
		String msg = null;
		if(flashMap != null){
			msg = (String)flashMap.get("msg");
		}
		
	    modelMap.addAttribute("msg", msg);
	    System.out.println("msg : "+msg);
		
		return "market";
	}
}
