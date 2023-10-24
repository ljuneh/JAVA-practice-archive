package com.springmybatis.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmybatis.dao.MemberDao;
import com.springmybatis.dto.Member;

public class RunMain {
	
	private static ClassPathXmlApplicationContext ctx = null;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:/com/springmybatis/config.xml");
		
		MemberDao memberDao = (MemberDao) ctx.getBean("memberDao");
		
//		Member member = memberDao.findMemberById("id1");
//		
////		Member insertMember = new Member();
////		insertMember.setId("id");
////		insertMember.setPassword("pw");
////		
////		int result = memberDao.insertMember(insertMember);
////		
////		System.out.println("update orders: " + result);
//		
//		System.out.println(member);
		
//		int result = memberDao.updateMembeAddressrById("id", "address");
//		System.out.println("update orders: " + result);
		
		
		List<Member> memberList = memberDao.findMember();
		for(Member member : memberList) {
			System.out.println(member);
		}
	}

}
