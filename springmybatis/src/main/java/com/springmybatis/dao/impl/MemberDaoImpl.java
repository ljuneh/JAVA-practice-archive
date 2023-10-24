package com.springmybatis.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.springmybatis.conditions.UpdateCondition;
import com.springmybatis.dao.MemberDao;
import com.springmybatis.dto.Member;

public class MemberDaoImpl implements MemberDao {
	
	private SqlSessionTemplate sqlSessionTemplate; 

	public MemberDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public Member findMemberById(String id) {
		return sqlSessionTemplate.selectOne("member.findMemberById", id);
	}

	@Override
	public int insertMember(Member member) {
		return sqlSessionTemplate.insert("member.insertMember", member);
	}

	@Override
	public int updateMembeAddressrById(String id, String address) {
		UpdateCondition uc = new UpdateCondition(id, address);
		
		return sqlSessionTemplate.update("member.updateCondition", uc);
	}

	@Override
	public List<Member> findMember() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("member.findMember");
	}

	

}
