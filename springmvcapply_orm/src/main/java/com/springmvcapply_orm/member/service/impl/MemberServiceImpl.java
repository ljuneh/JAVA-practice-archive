package com.springmvcapply_orm.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvcapply_orm.member.dao.MemberDao;
import com.springmvcapply_orm.member.entity.Member;
import com.springmvcapply_orm.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	@Transactional
	public int createMember(Member member) {
		int result = memberDao.create(member);
		return result;
	}

}
