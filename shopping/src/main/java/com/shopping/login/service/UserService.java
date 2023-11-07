package com.shopping.login.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.shopping.login.dao.UserInfoRepository;
import com.shopping.login.dto.LoginDto;
import com.shopping.login.dto.RegisterDto;
import com.shopping.login.entity.UserInfo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
	
	
	private final UserInfoRepository userInfoRepository;
	
	public String sessionCheck(HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession(false);
		String id = null;
		String name = null;
		String location = null;
		if(session!=null) {
			id = (String) session.getAttribute("id");
			name = (String) session.getAttribute("name");
		}
		
		String headermsg = "로그인";
		
		if(id!=null) {
			headermsg = name + " 로그아웃";
			location="redirect:/logout";
		} else {
			location="redirect:/loginpage";
		}
		modelMap.addAttribute("headermsg", headermsg);
		modelMap.addAttribute("location", location);
		
		return id;
	}
	
	public UserInfo login(LoginDto loginDto) {
		Optional<UserInfo> optionalUserInfo =  userInfoRepository.findById(loginDto.getId());
		UserInfo userInfo = null;
		
		if(optionalUserInfo.isEmpty()) {
			return null;
		}
		
		userInfo = optionalUserInfo.get();
		
		if(!userInfo.getPassword().equals(loginDto.getPassword())) {
			return null;
		}
		
		
		return userInfo;
	}
	
	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);  // Session이 없으면 null return
        if(session != null) {
            session.invalidate();
        }
	}
	
	public void register(RegisterDto registerDto) {
		
		
		UserInfo userInfo = UserInfo.createUserInfo(registerDto);
		userInfo =  userInfoRepository.save(userInfo);
	}
	
	public boolean findUserInfoById(String id) {
		boolean isexisted = userInfoRepository.existsById(id);
		return isexisted;
	}


}
