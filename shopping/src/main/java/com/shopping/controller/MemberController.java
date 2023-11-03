package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.dao.MemberRepository;
import com.shopping.entity.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberRepository memberRepository;
	
	
	@RequestMapping("retMember")
	public String retMember(ModelMap modelMap) {
		Member member = null;
		member = memberRepository.findById(1).orElse(member);
		
		modelMap.addAttribute("member", member);
		
		return "test";
	}

}
