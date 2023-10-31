package com.springmvcapply_orm.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvcapply_orm.member.dto.User;
import com.springmvcapply_orm.member.entity.Member;
import com.springmvcapply_orm.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("registrationPage")
	public String showRegistrationPage() {
		return "userReg";
	}
	
	@RequestMapping("registerUser")
	public String registerUser(@ModelAttribute("user") User user, ModelMap modelMap) {
		Member member = new Member();
		member.setId(user.getId());
		member.setName(user.getName());
		member.setPassword(user.getPassword());
		member.setAddress(user.getAddress());
		member.setEmail(user.getEmail());
		
		String result = memberService.createMember(member);
		
		modelMap.addAttribute("result", "user id : "+result);
		
		
		
		
		return "userReg";
	}
	

}
