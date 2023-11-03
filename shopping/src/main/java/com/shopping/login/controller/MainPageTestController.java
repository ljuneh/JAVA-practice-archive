package com.shopping.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.login.service.UserService;

@Controller
public class MainPageTestController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/mainTest")
	public String mainTest(HttpServletRequest request, ModelMap modelMap) {
		
		userService.sessionCheck(request, modelMap);
		return "market";
		
	}

}
