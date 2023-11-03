package com.shopping.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.login.dto.LoginDto;
import com.shopping.login.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginpage")
	public String registerpage() {
		return "login";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request, @ModelAttribute("logindto") LoginDto loginDto, ModelMap modelMap) {
		
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, ModelMap modelMap) {
		
		userService.logout(request);
		return "redirect:/shopping/market";
	}
	
	@RequestMapping("/loginstate")
	public String loginstate(HttpServletRequest request, ModelMap modelMap) {
		String id = userService.sessionCheck(request, modelMap);
		
		String location=(String) modelMap.getAttribute("location");
		
		return location;
		
		
	}
}
