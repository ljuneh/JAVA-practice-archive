package com.springmybatis.dao;

import java.util.List;

import com.springmybatis.dto.Member;

public interface MemberDao {
	
	Member findMemberById(String id);
	
	List<Member> findMember();
	
	
	
	int insertMember(Member member);
	
	int updateMembeAddressrById(String id, String address);
	

}
