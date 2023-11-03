package com.shopping;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.shopping.dao.MemberDao;
import com.shopping.dao.MemberRepository;
import com.shopping.entity.Member;

@SpringBootTest
class ShoppingApplicationTests {

	@Autowired
	ApplicationContext context;
	
	@Autowired
	private MemberDao memberDao;
	
//	@Test
	void getFindMember() {
		List<Member> memList = memberDao.findMember();
		for(Member member : memList) {
			System.out.println(member);
		}
	}
	
	@Test
	void getFindMemberByRepo() {
		MemberRepository repository = context.getBean(MemberRepository.class);
		
		List<Member> memList = (List<Member>) repository.findAll();
		for(Member member : memList) {
			System.out.println(member);
		}
		
	}
	


}
