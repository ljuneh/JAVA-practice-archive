package springjdbc.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springjdbc.dao.UserInfoDao;
import springjdbc.dto.UserInfoDto;

@Component("loginservice")
public class LoginService {
	private int loginCount = 3;
	
	@Autowired
	@Qualifier("userinfodao")
	private UserInfoDao userInfoDao;

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	
	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	private AdminService adminService;
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}





	public void enter(Scanner sc) {
		boolean isIdPassed = false;
		boolean isPasswordPassed = false;
		char role = 0;
		
		System.out.print("아이디 입력 >>> ");
		String enteredId = sc.nextLine();
		
		System.out.print("비밀번호 입력 >>> ");
		String enteredPassword = sc.nextLine();
		
		UserInfoDto userInfoDto = userInfoDao.read(enteredId);
		if((userInfoDto==null) && (--loginCount>0)) {
			System.out.println("처음 로그인으로 돌아옵니다. 로그인 카운트가 "+loginCount+"만큼 남았습니다");
			enter(sc);
			return;
		} else if((userInfoDto!=null) && (loginCount>0)) {
			isIdPassed = true;
			
		} else if(loginCount == 0) {
			System.out.println("로그인 카운트 제한 횟수 초과");
			return;
		}
		
		if(enteredPassword.equals(userInfoDto.getUserpassword())) {
			isPasswordPassed = true;
			role = userInfoDto.getRole().charAt(0);
		} else if((--loginCount>0)) {
			System.out.println("잘못된 비밀번호를 입력했습니다. " + "로그인 카운트가 "+loginCount+"만큼 남았습니다");
			enter(sc);
			return;
		} else if(loginCount == 0) {
			System.out.println("로그인 카운트 제한 횟수 초과");
			return;
		}
		
		if(isIdPassed&&isPasswordPassed&&(role=='a')) {
			System.out.println("로그인 성공");
			System.out.println("관리자 권한으로 로그인합니다");
			
			adminService.runMenu(sc);
		} else if(isIdPassed&&isPasswordPassed&&(role=='u')) {
			System.out.println("로그인 성공");
			System.out.println("사용자 권한으로 로그인합니다");
			
			userService.runMenu(sc, enteredId);
			
		}
	}
}
