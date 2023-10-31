package com.spring.boot.data;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.spring.boot.data.dao.MemberDao;
import com.spring.boot.data.dto.Member;

@SpringBootTest
class SpringbootdatamybatisApplicationTests {

	@Autowired
	ApplicationContext context;
	@Autowired
	private MemberDao memberDao;
	@Test
	void getFindMember() {
		List<Member> memList = memberDao.findMember();
		for(Member member : memList) {
			System.out.println(member);
		}
	}

}
