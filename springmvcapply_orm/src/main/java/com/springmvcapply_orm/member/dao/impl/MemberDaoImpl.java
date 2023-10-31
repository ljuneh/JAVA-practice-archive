package com.springmvcapply_orm.member.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.springmvcapply_orm.member.dao.MemberDao;
import com.springmvcapply_orm.member.entity.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public String create(Member member) {
		String result = (String) hibernateTemplate.save(member);
		return result;
	}

}
