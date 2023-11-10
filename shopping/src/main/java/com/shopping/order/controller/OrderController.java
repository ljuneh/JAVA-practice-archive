package com.shopping.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopping.login.service.UserService;
import com.shopping.order.dao.OrderInfoRepository;
import com.shopping.order.entity.OrderInfo;
import com.shopping.order.service.BasketService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {
	
	private final UserService userService;
	private final BasketService basketService;
	
	
	@RequestMapping("/ordertobasket")
	public String orderToBasket(HttpServletRequest request, @RequestParam("code") String code, @RequestParam("quantity") int quantity, ModelMap modelMap, RedirectAttributes redirectAtt) {
		String id = userService.sessionCheck(request, modelMap);
		
		if(id==null) {
			return "redirect:/loginpage";
		} else {
			OrderInfo orderInfo = basketService.orderGoods(id, code, quantity);
			
			String msg = String.format("상품이름 : %s %d개가 장바구니에 담겼습니다", orderInfo.getOrderGoods().getGoodsName(), orderInfo.getOrderQuantity());
			
			
			redirectAtt.addFlashAttribute("msg", msg);
			System.out.println(msg);
			
		}
		
		return "redirect:/displayinsales";
	}
	
	@RequestMapping("/deletebasket")
	public String deleteBasket(@RequestParam("seq") int seq, ModelMap modelMap) {
		basketService.deleteGoodsInBasket(seq);
		
		return "redirect:/displaybasket";
	}
	
}
