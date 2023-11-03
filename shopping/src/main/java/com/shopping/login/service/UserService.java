package com.shopping.login.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.shopping.login.dao.UserInfoRepository;
import com.shopping.login.dto.LoginDto;
import com.shopping.login.entity.UserInfo;

@Service
public class UserService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public String sessionCheck(HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession(false);
		String id = null;
		String location = null;
		if(session!=null) {
			id = (String) session.getAttribute("id");
		}
		
		String headermsg = "로그인";
		
		if(id!=null) {
			headermsg = id + " 로그아웃";
			location="redirect:/shopping/loginpage";
		} else {
			location="redirect:/shopping/logout";
		}
		modelMap.addAttribute("headermsg", headermsg);
		modelMap.addAttribute("location", location);
		
		return id;
	}
	
	public void login(LoginDto loginDto) {
		Optional<UserInfo> optionalUserInfo =  userInfoRepository.findById(loginDto.getId());
		UserInfo userinfo = null;
		
		if(optionalUserInfo.isEmpty()) {
			
		}
	}
	
	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);  // Session이 없으면 null return
        if(session != null) {
            session.invalidate();
        }
	}


}
