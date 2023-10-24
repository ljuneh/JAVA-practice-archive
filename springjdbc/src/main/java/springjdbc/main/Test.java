package springjdbc.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springjdbc.dao.UserInfoDao;
import springjdbc.dto.UserInfoDto;
import springjdbc.service.LoginService;

public class Test {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:/springjdbc/main/config.xml");
		
//		UserInfoDao userInfoDao = (UserInfoDao) ctx.getBean("userinfodao");
		
//		UserInfoDto userInfoDto = new UserInfoDto();
//		userInfoDto.setUserid("user0").setUserpassword("user0").setRole("u");
//		
////		int cnt = userInfoDao.create(userInfoDto);
//		
////		int cnt = userInfoDao.updateRole(userInfoDto, "a");
//		
////		int cnt = userInfoDao.delete(userInfoDto);
//		 
////		System.out.println("입력된 갯수: " + cnt);
		
//		UserInfoDto userInfoDto = userInfoDao.read("user1");
//		System.out.println(userInfoDto);
//		
//		List<UserInfoDto> userInfoDtoList = userInfoDao.read();
//		for(UserInfoDto userinfoDto: userInfoDtoList) {
//			System.out.println(userinfoDto);
//		}
		
//		List<UserInfoDto> userInfoDtoList = userInfoDao.readByRole("u");
//		for(UserInfoDto userinfoDto: userInfoDtoList) {
//			System.out.println(userinfoDto);
//		}
		
		Scanner sc = new Scanner(System.in);
		
		
		LoginService loginService = (LoginService) ctx.getBean("loginservice");
		loginService.enter(sc);
		
		
		sc.close();
	}
}
