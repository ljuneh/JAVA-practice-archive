package com.shopping.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.login.dto.LoginDto;
import com.shopping.login.dto.RegisterDto;
import com.shopping.login.entity.UserInfo;
import com.shopping.login.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	private final UserService userService;

	@RequestMapping("/loginpage")
	public String loginpage() {
		return "login";
	}

	@RequestMapping("/login")
	@PostMapping
	public String login(HttpServletRequest request, @ModelAttribute("loginDto") LoginDto loginDto,
			BindingResult bindingResult, ModelMap modelMap) {

		UserInfo userInfo = userService.login(loginDto);
		if (userInfo == null) {
			bindingResult.reject("error.global", "아이디 또는 비밀번호가 틀렸습니다");
		}
		if(bindingResult.hasErrors()) {
//			List<ObjectError> errorList =  bindingResult.getAllErrors();
//			for(ObjectError error : errorList) {
//				System.out.println(error);
//			}
            return "login";
        }
		
		request.getSession().invalidate();
		HttpSession session = request.getSession(true);
		session.setAttribute("id", userInfo.getId());
		session.setAttribute("name", userInfo.getName());
		session.setMaxInactiveInterval(1800);
		
		if(userInfo.getAuth().equals("A")) {
			return "redirect:/stock";
		}
		return "redirect:/displayinsales";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, ModelMap modelMap) {

		userService.logout(request);
		return "redirect:/displayinsales";
	}

	@RequestMapping("/loginstate")
	public String loginstate(HttpServletRequest request, ModelMap modelMap) {
		String id = userService.sessionCheck(request, modelMap);

		String location = (String) modelMap.getAttribute("location");

		return location;

	}
	
	@RequestMapping("/registerpage")
	public String registerpage(ModelMap modelMap) {
		modelMap.addAttribute("registerDto", new RegisterDto());
		return "register";
	}
	
	@RequestMapping("/registration")
	@PostMapping
	public String registration(@ModelAttribute("registerDto") RegisterDto registerDto, BindingResult bindingResult, ModelMap modelMap) {
		boolean isexisted = userService.findUserInfoById(registerDto.getId());
		
		if(isexisted) {
			bindingResult.addError(new FieldError("registerDto", "id", "로그인 아이디가 중복됩니다."));
		}
		
		if(bindingResult.hasErrors()) {
			return "register";
		}
		
		userService.register(registerDto);
		
		return "redirect:/loginpage";
	}
}
